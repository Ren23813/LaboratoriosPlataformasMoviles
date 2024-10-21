package com.uvg.renato.lab8.presentation.mainFlow.character

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.uvg.renato.lab8.presentation.mainFlow.character.charactersList.CharacterListDestination
import com.uvg.renato.lab8.presentation.mainFlow.character.charactersList.characterListScreen
import com.uvg.renato.lab8.presentation.mainFlow.character.charactersProfile.CharactersProfileDestination
import com.uvg.renato.lab8.presentation.mainFlow.character.charactersProfile.characterProfileScreen
import com.uvg.renato.lab8.presentation.mainFlow.character.charactersProfile.navigateToCharacterProfileScreen
import kotlinx.serialization.Serializable

@Serializable
data object CharacterNavGraph

fun NavGraphBuilder.characterGraph(
    navController: NavController
) {
    navigation<CharacterNavGraph>(
        startDestination = CharacterListDestination
    ) {
        characterListScreen(
            onCharacterClick = navController::navigateToCharacterProfileScreen
        )
        characterProfileScreen(
            onNavigateBack = navController::navigateUp
        )
    }
}