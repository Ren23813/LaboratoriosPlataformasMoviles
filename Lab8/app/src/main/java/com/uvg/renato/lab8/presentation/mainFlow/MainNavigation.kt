package com.uvg.renato.lab8.presentation.mainFlow

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uvg.renato.lab8.data.source.UserPreferences
import kotlinx.serialization.Serializable

@Serializable
data object MainNavigationGraph

fun NavController.navigateToMainGraph(navOptions: NavOptions?= null){
    this.navigate(MainNavigationGraph,navOptions)
}

fun NavGraphBuilder.mainNavigationGraph(onLogOutClick: () -> Unit,userPreferences: UserPreferences){
composable<MainNavigationGraph> {
    val nestedNavController = rememberNavController()
    MainFlowScreen(
        navController = nestedNavController,
        onLogOutClick = onLogOutClick,
        userPreferences = userPreferences
    )
}
}
