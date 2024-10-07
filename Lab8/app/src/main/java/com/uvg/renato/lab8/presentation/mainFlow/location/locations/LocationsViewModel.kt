package com.uvg.renato.lab8.presentation.mainFlow.location.locations

import android.provider.CallLog
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.uvg.renato.lab8.data.model.Location
import com.uvg.renato.lab8.data.source.LocationDb
import com.uvg.renato.lab8.presentation.mainFlow.location.locationDetails.LocationDetailsDestination
import com.uvg.renato.lab8.presentation.mainFlow.location.locationDetails.LocationDetailsState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class LocationsViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel(){
    private  val locationDB = LocationDb()
    private  val locations = savedStateHandle.toRoute<LocationsDestination>()
    private val _uiState: MutableStateFlow<LocationsState> = MutableStateFlow(
        LocationsState()
    )
    val uiState = _uiState.asStateFlow()

    fun getLocationsList() {
        viewModelScope.launch {
            _uiState.update { state ->state.copy(loading = true) }
            delay(4000)
            val locations = locationDB.getAllLocations()
            _uiState.update { state ->state.copy(loading = false) }

        }
    }
}