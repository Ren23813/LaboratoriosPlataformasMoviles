package com.uvg.renato.lab8.presentation.mainFlow.userProfile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.uvg.renato.lab8.presentation.login.*
import kotlinx.serialization.Serializable


@Serializable
data object UserProfileDestination

fun NavGraphBuilder.userProfileScreen(
    onLogOutClick: () -> Unit
) {
    composable<UserProfileDestination> {
        UserProfileRoute(onLogOutClick = onLogOutClick)
    }
}