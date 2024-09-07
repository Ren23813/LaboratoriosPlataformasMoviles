package com.uvg.renato.lab8.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.uvg.renato.lab8.charactersList.CharacterListDestination
import kotlinx.serialization.Serializable

@Serializable
data object LoginDestination

fun NavController.navigateToCharacterListScreen(
    destination: CharacterListDestination,
    navOptions: NavOptions? = null
) {
    this.popBackStack()
    this.navigate(destination, navOptions)

}

fun NavGraphBuilder.loginScreen(
    onButtonClick: () -> Unit,
) {
    composable<LoginDestination> {
        LoginRoute(
            onButtonClick = onButtonClick,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}