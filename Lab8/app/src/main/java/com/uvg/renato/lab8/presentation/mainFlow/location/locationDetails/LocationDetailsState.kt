package com.uvg.renato.lab8.presentation.mainFlow.location.locationDetails

import coil.compose.AsyncImagePainter
import com.uvg.renato.lab8.data.model.Location

data class LocationDetailsState(
    val data: Location? = null,
    val loading: Boolean = false,
    val error: Boolean = false
)