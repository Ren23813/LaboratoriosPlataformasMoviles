package com.uvg.renato.lab8.userProfile

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.uvg.renato.lab8.charactersList.CharacterListDestination
import com.uvg.renato.lab8.locations.LocationsDestination
import com.uvg.renato.lab8.login.LoginDestination
import com.uvg.renato.lab8.login.LoginRoute
import com.uvg.renato.lab8.login.navigateToCharacterListScreen
import kotlinx.serialization.Serializable


@Serializable
data object UserProfileDestination

fun NavController.navigateToLoginScreen(
    navOptions: NavOptions? = null
) {
    for (item in this.graph){
        this.popBackStack()
    }

    this.navigate(LoginDestination, navOptions)
}

fun NavGraphBuilder.userProfileScreen(
    onButtonClick: () -> Unit,
) {
    composable<UserProfileDestination> {
        UserProfileRoute(
            onButtonClick = onButtonClick,
            modifier = Modifier.fillMaxWidth(),
        )
    }

}

fun NavController.navigateToUserProfileScreen(
    destination: UserProfileDestination,
    navOptions: NavOptions? = null
) {
    this.navigate(destination, navOptions)

}

