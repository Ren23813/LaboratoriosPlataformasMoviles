package com.uvg.renato.lab8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.uvg.renato.lab8.ui.theme.Lab8Theme
import com.uvg.renato.lab8.charactersList.CharacterListDestination
import com.uvg.renato.lab8.charactersList.characterListScreen
import com.uvg.renato.lab8.charactersProfile.characterProfileScreen
import com.uvg.renato.lab8.charactersProfile.CharactersProfileDestination
import com.uvg.renato.lab8.charactersProfile.navigateToCharacterProfileScreen
import com.uvg.renato.lab8.login.LoginDestination
import com.uvg.renato.lab8.login.loginScreen
import com.uvg.renato.lab8.login.navigateToCharacterListScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab8Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize().safeDrawingPadding(),
                ) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = LoginDestination,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        characterListScreen(
                            onCharacterClick = { character ->
                                navController.navigateToCharacterProfileScreen(
                                    destination = CharactersProfileDestination(
                                        characterId = character.id,
                                    )
                                )
                            }
                        )
                        loginScreen(
                            onButtonClick = { navController.navigateToCharacterListScreen(destination = CharacterListDestination) })
                        characterProfileScreen(
                            onNavigateBack = {
                                navController.navigateUp()
                            }
                        )
                    }
                }
            }
        }
    }

}