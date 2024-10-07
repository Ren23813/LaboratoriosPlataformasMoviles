package com.uvg.renato.lab8.presentation.mainFlow.location.locationDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.uvg.renato.lab8.data.source.LocationDb
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LocationDetailsViewModel(
    savedStateHandle: SavedStateHandle): ViewModel(){
    private  val locationDB = LocationDb()
    private  val locationDetails = savedStateHandle.toRoute<LocationDetailsDestination>()
    private val _uiState: MutableStateFlow<LocationDetailsState> = MutableStateFlow(LocationDetailsState())
    val uiState = _uiState.asStateFlow()

    fun getLocationData(){
        viewModelScope.launch {
            _uiState.update { state ->state.copy(loading = true) }
            delay(2000)
            val location = locationDB.getLocationById(locationDetails.locationId)
            _uiState.update { state ->state.copy(loading = false) }
        }
    }
}