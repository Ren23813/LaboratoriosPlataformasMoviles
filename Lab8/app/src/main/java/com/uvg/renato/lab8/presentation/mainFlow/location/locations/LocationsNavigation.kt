package com.uvg.renato.lab8.presentation.mainFlow.location.locations

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.uvg.renato.lab8.data.model.Location
import kotlinx.serialization.Serializable


@Serializable
data object LocationsDestination

fun NavGraphBuilder.locationsScreen(
    onLocationClick: (Int) -> Unit
) {
    composable<LocationsDestination> {
        LocationsRoute(
            onLocationClick = onLocationClick,
        )
    }

}
