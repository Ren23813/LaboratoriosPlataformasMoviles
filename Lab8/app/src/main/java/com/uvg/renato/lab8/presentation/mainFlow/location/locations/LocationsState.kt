package com.uvg.renato.lab8.presentation.mainFlow.location.locations

import com.uvg.renato.lab8.data.model.Location

data class LocationListState(
    val isLoading: Boolean = true,
    val locations: List<Location> = emptyList(),
    val isError: Boolean = false
)