package com.uvg.renato.lab8.presentation.mainFlow.location

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.navigation
import com.uvg.renato.lab8.presentation.mainFlow.location.locationDetails.LocationDetailsDestination
import com.uvg.renato.lab8.presentation.mainFlow.location.locations.LocationsDestination
import com.uvg.renato.lab8.presentation.mainFlow.location.locations.locationsScreen
import com.uvg.renato.lab8.presentation.mainFlow.location.locationDetails.locationDetailsScreen
import com.uvg.renato.lab8.presentation.mainFlow.location.locationDetails.navigateToLocationDetailsScreen
import kotlinx.serialization.Serializable


@Serializable
data object LocationsNavGraph

fun NavController.navigateToLocationsGraph(navOptions: NavOptions? = null){
    this.navigate(LocationsNavGraph,navOptions)
}

fun NavGraphBuilder.locationsGraph(
    navController: NavController
) {
    navigation<LocationsNavGraph>(
        startDestination = LocationsDestination
    ) {
        locationsScreen(
            onLocationClick = navController::navigateToLocationDetailsScreen
        )
        locationDetailsScreen(
            onNavigateBack = navController::navigateUp
        )
    }
}