package com.uvg.renato.lab8.presentation.mainFlow.location.locationDetails

import coil.compose.AsyncImagePainter
import com.uvg.renato.lab8.data.model.Location
data class LocationProfileState(
    val data: Location? = null,
    val isLoading: Boolean = true
)