package com.uvg.renato.lab8.locationDetails

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.uvg.renato.lab8.charactersProfile.CharacterProfileRoute
import kotlinx.serialization.Serializable


@Serializable
data class LocationDetailsDestination(
    val characterId: Int,
)

fun NavController.navigateToLocationDetailsScreen(
    destination: LocationDetailsDestination,
    navOptions: NavOptions? = null
) {
    this.navigate(destination, navOptions)

}

fun NavGraphBuilder.locationDetailsScreen(
    onNavigateBack: () -> Unit
) {
    composable<LocationDetailsDestination> { backStackEntry ->
        val destination: LocationDetailsDestination = backStackEntry.toRoute()
        LocationDetailsRoute(
            id = destination.characterId,
            onNavigateBack = onNavigateBack
        )
    }
}