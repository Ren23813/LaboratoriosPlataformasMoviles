package com.uvg.renato.lab8.presentation.mainFlow.location.locations

sealed interface LocationsEvent {
    data object ForceError: LocationsEvent
    data object RetryClick: LocationsEvent
}