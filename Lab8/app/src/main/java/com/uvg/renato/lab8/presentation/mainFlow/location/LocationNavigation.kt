package com.uvg.renato.lab8.presentation.mainFlow.location

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.navigation
import com.uvg.renato.lab8.presentation.mainFlow.location.locationDetails.LocationDetailsDestination
import com.uvg.renato.lab8.presentation.mainFlow.location.locations.LocationListDestination
import com.uvg.renato.lab8.presentation.mainFlow.location.locations.locationListScreen
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
        startDestination = LocationListDestination
    ) {
        locationListScreen(
            onLocationClick = navController::navigateToLocationDetailsScreen
        )
        locationDetailsScreen(
            onNavigateBack = navController::navigateUp
        )
    }
}