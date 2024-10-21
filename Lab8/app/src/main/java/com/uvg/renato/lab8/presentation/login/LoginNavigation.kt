package com.uvg.renato.lab8.presentation.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.uvg.renato.lab8.data.source.UserPreferences
import com.uvg.renato.lab8.presentation.mainFlow.character.charactersList.CharacterListDestination
import kotlinx.serialization.Serializable

@Serializable
data object LoginDestination

fun NavGraphBuilder.loginScreen(
    onLoginClick: () -> Unit,
    userPreferences: UserPreferences
) {
    composable<LoginDestination> {
        LoginRoute(
            onLoginClick = onLoginClick,
            userPreferences = userPreferences

        )
    }
}