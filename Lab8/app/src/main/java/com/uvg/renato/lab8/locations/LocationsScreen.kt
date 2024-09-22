package com.uvg.renato.lab8.locations

import Location
import LocationDb
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.uvg.renato.lab8.Character
import com.uvg.renato.lab8.CharacterDb


@Composable
fun LocationsRoute(
    onLocationClick: (Location) -> Unit,
    modifier: Modifier = Modifier
) {
    LocationsScreen(
        onLocationClick = onLocationClick,
        modifier = modifier
    )
}

val myLocDB = LocationDb()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LocationsScreen(
    onLocationClick: (Location) -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        var selectedItem by remember { mutableStateOf(0) }
        TopAppBar(
            modifier = Modifier
                .height(75.dp)
                .fillMaxWidth(),
            title = { Text(text = "Locations", style = MaterialTheme.typography.titleLarge) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
        LazyColumn(modifier.weight(0.8f)) {
            items(myLocDB.getAllLocations()) { location ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .clickable { onLocationClick(location) }
                ) {
                    Row {
                        Column {
                            Text(
                                text = location.name,
                                modifier = Modifier
                                    .padding(start = 16.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = location.type,
                                modifier = Modifier.padding(start = 16.dp),
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                    }
                }
            }
        }

    }
}
