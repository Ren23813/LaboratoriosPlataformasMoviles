package com.uvg.renato.lab8.presentation.mainFlow.character.charactersList
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.uvg.renato.lab8.data.model.Character
import com.uvg.renato.lab8.presentation.mainFlow.location.locations.LocationsDestination
import kotlinx.serialization.Serializable

@Serializable
data object CharacterListDestination

fun NavGraphBuilder.characterListScreen(
    onCharacterClick: (Character) -> Unit
) {
    composable<CharacterListDestination> {
        CharacterListRoute(
            onCharacterClick = onCharacterClick,
            modifier = Modifier.fillMaxWidth()
        )
    }
}


fun NavController.navigateToLocationsScreen(
    destination: LocationsDestination,

    navOptions: NavOptions? = null
) {
    this.navigate(destination, navOptions)

}