package com.uvg.renato.lab8.presentation.mainFlow.location.locations

import com.uvg.renato.lab8.data.model.Location
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import com.uvg.renato.lab8.data.source.LocationDb
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uvg.renato.lab8.presentation.mainFlow.location.locationDetails.LocationDetailsState
import com.uvg.renato.lab8.presentation.mainFlow.location.locationDetails.LocationDetailsViewModel


@Composable
fun LocationsRoute(
    onLocationClick:(Int)->Unit,
    viewModel: LocationDetailsViewModel = viewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    LocationsScreen(
        state =state,
        onLocationClick = {viewModel.getLocationData()},
        modifier = Modifier.fillMaxSize()
    )
}

val myDb = LocationDb()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LocationsScreen(
    state: LocationDetailsState,
    onLocationClick: (Int) -> Unit,
    modifier:Modifier = Modifier
    ) {
    Column {
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
        LazyColumn(modifier = Modifier.weight(0.8f)) {

            items(myDb.getAllLocations().size) {
                LocationsContent(location = state.data, hasError = state.error, isLoading = state.loading, modifier = Modifier
                    .fillMaxWidth()
                    .clickable { state.data?.let { onLocationClick(it.id) } })

            }
        }
    }
}

@Composable
fun LocationsContent(location:Location?,modifier:Modifier = Modifier   , isLoading:Boolean,
                     hasError:Boolean,)
{
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Row {
                        Column {
                            if (location != null) {
                                Text(
                                    text = location.name.toString(),
                                    modifier = Modifier
                                        .padding(start = 16.dp),
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                            if (location != null) {
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
