package com.uvg.renato.lab8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.compose.rememberNavController
import com.uvg.renato.lab8.presentation.navigation.AppNavigation
import com.uvg.renato.lab8.ui.theme.Lab8Theme
import android.content.Context
import com.uvg.renato.lab8.data.source.UserPreferences

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val userPreferences = UserPreferences(dataStore = dataStore)
            Lab8Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(
                        modifier = Modifier.fillMaxSize().padding(innerPadding),
                        navController = navController,
                        userPreferences = userPreferences
                    )
                }
            }
        }


    }
}


//@Composable
//fun BottomNavigationBar(navController: NavController) {
//
//    val items = listOf("Characters", "Locations", "Profile")
//    val icons = listOf(Icons.Default.Face, Icons.Default.LocationOn, Icons.Default.Person)
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentDestination = navBackStackEntry?.destination?.route
//    val selectedItem = when (currentDestination) {
//        CharacterListDestination.toString() -> 0
//        LocationsDestination.toString() -> 1
//        UserProfileDestination.toString() -> 2
//        else -> -1
//    }
//
//    val shouldShowBottomAppBar = currentDestination != LoginDestination.toString()
//
//    if (shouldShowBottomAppBar) {
//        BottomAppBar {
//            NavigationBar {
//                items.forEachIndexed { index, label ->
//                    NavigationBarItem(
//                        selected = selectedItem == index,
//                        onClick = {
//                            when (index) {
//                                0 -> navController.navigateToCharacterListScreen(destination = CharacterListDestination)
//                                1 -> navController.navigateToLocationsScreen(destination = LocationsDestination)
//                                2 -> navController.navigateToUserProfileScreen(destination = UserProfileDestination)
//                            }
//                        },
//                        label = { Text(label) },
//                        icon = { Icon(icons[index], contentDescription = null) } // Usamos el ícono correspondiente
//                    )
//                }
//            }
//        }
//    }
//}
