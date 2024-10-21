package com.uvg.renato.lab8.presentation.mainFlow.location.locationDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import com.uvg.renato.lab8.data.model.Location
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.toRoute
import com.uvg.renato.lab8.data.local.LocationDb
import com.uvg.renato.lab8.data.local.dao.LocationDao
import com.uvg.renato.lab8.data.local.entity.mapToEntity
import com.uvg.renato.lab8.data.local.entity.mapToModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import com.uvg.renato.lab8.data.repository.LocalLocationRepository
import com.uvg.renato.lab8.domainRepo.repository.LocationRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import com.uvg.renato.lab8.dependencies.Dependencies
class LocationDetailsViewModel(
    private val locationsDao: LocationDao,
    private val locationsRepository: LocationRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val locationProfile = savedStateHandle.toRoute<LocationDetailsDestination>()
    private val _state: MutableStateFlow<LocationProfileState> = MutableStateFlow(LocationProfileState())
    val state = _state.asStateFlow()

    init {
        getLocationData()
    }

    private fun getLocationData() {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(isLoading = true)
            }

            val location = locationsRepository.getLocationById(locationProfile.locationId)

            _state.update { state ->
                state.copy(
                    data = location,
                    isLoading = false
                )
            }
        }
    }

    private val _locationName = MutableStateFlow("")

    fun addLocation() {
        viewModelScope.launch {
            val newLocation = Location(
                id = 0, // Room auto-genera el ID
                name = _locationName.value,
                type = "",
                dimension = ""
            )
            locationsDao.insertAllLocations(listOf(newLocation.mapToEntity()))
            _locationName.value = ""
        }
    }

    // Factory para crear el ViewModel
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = checkNotNull(this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                val repository = Dependencies.provideLocationRepository(application)
                val savedStateHandle = this.createSavedStateHandle()
                val dao = Dependencies.provideLocationDao(application)
                LocationDetailsViewModel(locationsDao = dao, locationsRepository = repository, savedStateHandle = savedStateHandle)
            }
        }
    }
}
