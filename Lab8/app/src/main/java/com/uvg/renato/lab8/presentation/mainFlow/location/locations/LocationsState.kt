package com.uvg.renato.lab8.presentation.mainFlow.location.locations

import com.uvg.renato.lab8.data.model.Location

data class LocationsState(
    val data: Location? = null,
    val loading: Boolean = false,
    val error: Boolean = false
)