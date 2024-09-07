package com.uvg.renato.lab8.charactersProfile
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.uvg.renato.lab8.CharacterDb
import kotlinx.serialization.Serializable

@Serializable
data class CharactersProfileDestination(
    val characterId: Int,
)

fun NavController.navigateToCharacterProfileScreen(
    destination: CharactersProfileDestination,
    navOptions: NavOptions? = null
) {
    this.navigate(destination, navOptions)
}

fun NavGraphBuilder.characterProfileScreen(
    onNavigateBack: () -> Unit
) {
    composable<CharactersProfileDestination> { backStackEntry ->
        val destination: CharactersProfileDestination = backStackEntry.toRoute()
        CharacterProfileRoute(
            id = destination.characterId,
            onNavigateBack = onNavigateBack
        )
    }
}