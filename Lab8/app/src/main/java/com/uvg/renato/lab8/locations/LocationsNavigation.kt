package com.uvg.renato.lab8.locations

import Location
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.uvg.renato.lab8.Character
import com.uvg.renato.lab8.charactersList.CharacterListDestination
import com.uvg.renato.lab8.charactersList.CharacterListRoute
import kotlinx.serialization.Serializable


@Serializable
data object LocationsDestination

fun NavGraphBuilder.locationsScreen(
    onLocationClick: (Location) -> Unit
) {
    composable<LocationsDestination> {
        LocationsRoute(
            onLocationClick = onLocationClick,
            modifier = Modifier.fillMaxWidth()
        )
    }

}
