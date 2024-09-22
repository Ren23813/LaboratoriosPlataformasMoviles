package com.uvg.renato.lab8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.uvg.renato.lab8.charactersList.CharacterListDestination
import com.uvg.renato.lab8.charactersList.characterListScreen
import com.uvg.renato.lab8.charactersList.navigateToLocationsScreen
import com.uvg.renato.lab8.charactersProfile.CharactersProfileDestination
import com.uvg.renato.lab8.charactersProfile.characterProfileScreen
import com.uvg.renato.lab8.charactersProfile.navigateToCharacterProfileScreen
import com.uvg.renato.lab8.locationDetails.LocationDetailsDestination
import com.uvg.renato.lab8.locationDetails.locationDetailsScreen
import com.uvg.renato.lab8.locationDetails.navigateToLocationDetailsScreen
import com.uvg.renato.lab8.locations.LocationsDestination
import com.uvg.renato.lab8.locations.locationsScreen
import com.uvg.renato.lab8.login.LoginDestination
import com.uvg.renato.lab8.login.loginScreen
import com.uvg.renato.lab8.login.navigateToCharacterListScreen
import com.uvg.renato.lab8.ui.theme.Lab8Theme
import com.uvg.renato.lab8.userProfile.UserProfileDestination
import com.uvg.renato.lab8.userProfile.navigateToLoginScreen
import com.uvg.renato.lab8.userProfile.navigateToUserProfileScreen
import com.uvg.renato.lab8.userProfile.userProfileScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab8Theme {
                val navController = rememberNavController()
                var notLogin by remember { mutableStateOf(false)}

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding(),
                    bottomBar = {
                            if(notLogin) {

                                BottomNavigationBar(navController)
                            }

                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = LoginDestination,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {


                        locationsScreen(onLocationClick = { location ->
                            navController.navigateToLocationDetailsScreen(
                                destination = LocationDetailsDestination(characterId = location.id)
                            )
                        })
                        locationDetailsScreen(onNavigateBack = { navController.navigateUp() })
                        userProfileScreen(onButtonClick = {
                            navController.navigateToLoginScreen(

                            )
                        notLogin = false
                        })
                        characterListScreen(onCharacterClick = { character ->
                            navController.navigateToCharacterProfileScreen(
                                destination = CharactersProfileDestination(characterId = character.id)
                            )
                        })
                        loginScreen(onButtonClick = {
                            navController.navigateToCharacterListScreen(
                                destination = CharacterListDestination
                            )
                        notLogin = true
                        })
                        characterProfileScreen(onNavigateBack = { navController.navigateUp() })

                    }
                }
            }
        }
    }


}
@Composable
fun BottomNavigationBar(navController: NavController) {

    val items = listOf("Characters", "Locations", "Profile")
    val icons = listOf(Icons.Default.Face, Icons.Default.LocationOn, Icons.Default.Person)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route
    val selectedItem = when (currentDestination) {
        CharacterListDestination.toString() -> 0
        LocationsDestination.toString() -> 1
        UserProfileDestination.toString() -> 2
        else -> -1
    }

    val shouldShowBottomAppBar = currentDestination != LoginDestination.toString()

    if (shouldShowBottomAppBar) {
        BottomAppBar {
            NavigationBar {
                items.forEachIndexed { index, label ->
                    NavigationBarItem(
                        selected = selectedItem == index,
                        onClick = {
                            when (index) {
                                0 -> navController.navigateToCharacterListScreen(destination = CharacterListDestination)
                                1 -> navController.navigateToLocationsScreen(destination = LocationsDestination)
                                2 -> navController.navigateToUserProfileScreen(destination = UserProfileDestination)
                            }
                        },
                        label = { Text(label) },
                        icon = { Icon(icons[index], contentDescription = null) } // Usamos el ícono correspondiente
                    )
                }
            }
        }
    }
}
