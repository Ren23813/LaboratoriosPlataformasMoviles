package com.uvg.renato.lab8.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.uvg.renato.lab8.presentation.login.LoginDestination
import com.uvg.renato.lab8.presentation.login.loginScreen
import com.uvg.renato.lab8.presentation.mainFlow.mainNavigationGraph
import com.uvg.renato.lab8.presentation.mainFlow.navigateToMainGraph

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    userPreferences: com.uvg.renato.lab8.data.source.UserPreferences
) {

    NavHost(
        navController = navController,
        startDestination = LoginDestination,
        modifier = modifier
    ) {
        loginScreen(onLoginClick = {
            navController.navigateToMainGraph(
                navOptions = NavOptions.Builder().setPopUpTo<LoginDestination>(inclusive = true).build()
            )
        }, userPreferences = userPreferences) // Pasar userPreferences aquí

        mainNavigationGraph(userPreferences = userPreferences,onLogOutClick = { navController.navigate(LoginDestination) { popUpTo(0) } })
    }
}
