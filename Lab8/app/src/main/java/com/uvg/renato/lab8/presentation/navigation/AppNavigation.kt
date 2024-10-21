package com.uvg.renato.lab8.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.uvg.renato.lab8.data.repository.UserPreferences
import com.uvg.renato.lab8.presentation.login.LoginDestination
import com.uvg.renato.lab8.presentation.login.loginScreen
import com.uvg.renato.lab8.presentation.mainFlow.mainNavigationGraph
import com.uvg.renato.lab8.presentation.mainFlow.navigateToMainGraph
import kotlinx.coroutines.launch

@Composable
fun AppNavigation(
    modifier:Modifier= Modifier,
    navController: NavHostController = rememberNavController()
){
    val coroutineScope = rememberCoroutineScope()
    val userPreferences = UserPreferences(navController.context)
    NavHost(
        navController=navController,
        startDestination = LoginDestination,
        modifier=modifier
    ){
      loginScreen (onLoginClick = {
          navController.navigateToMainGraph(
              navOptions = NavOptions.Builder().setPopUpTo<LoginDestination>(inclusive =true).build()
          )

      })
        mainNavigationGraph (onLogOutClick = {navController.navigate(LoginDestination) {popUpTo(0)} })
    }
}