package com.uvg.renato.lab8.presentation.mainFlow.location.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.uvg.renato.lab8.data.local.dao.LocationDao
import com.uvg.renato.lab8.data.repository.LocalLocationRepository
import com.uvg.renato.lab8.dependencies.Dependencies
import com.uvg.renato.lab8.domainRepo.repository.LocationRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LocationListViewModel(
    private val locationRepository: LocationRepository
) : ViewModel() {

    private var getDataJob: Job? = null
    private var _state = MutableStateFlow(LocationListState())
    val state = _state.asStateFlow()

    init {
        getLocations()
    }

//    fun onEvent(event: LocationsEvent) {
//        when (event) {
//            LocationsEvent.ForceError -> {
//                getDataJob?.cancel()
//                _state.update { state ->
//                    state.copy(
//                        isLoading = false,
//                        isError = true
//                    )
//                }
//            }
//            LocationsEvent.RetryClick -> {
//                getLocations()
//            }
//        }
//    }

    private fun getLocations() {
        getDataJob = viewModelScope.launch {
            _state.update { state ->
                state.copy(
                    isLoading = true,
                    isError = false
                )
            }

            val locations = locationRepository.getLocations()

            _state.update { state ->
                state.copy(
                    isLoading = false,
                    locations = locations
                )
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = checkNotNull(this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                val repository = Dependencies.provideLocationRepository(application)
                LocationListViewModel(repository)
            }
        }
    }

}
