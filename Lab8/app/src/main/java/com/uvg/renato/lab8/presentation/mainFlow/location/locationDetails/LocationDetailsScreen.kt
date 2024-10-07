package com.uvg.renato.lab8.presentation.mainFlow.location.locationDetails

import com.uvg.renato.lab8.data.source.LocationDb
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uvg.renato.lab8.data.model.Location



@Composable
fun LocationDetailsRoute(
    onNavigateBack: () -> Unit,
    viewModel: LocationDetailsViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LocationDetailsScreen(
        state = state,
        onNavigateBack =onNavigateBack,
        onInfoClick = {viewModel.getLocationData()}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LocationDetailsScreen(
    state:LocationDetailsState,
    onInfoClick:() -> Unit,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "Location Details", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic ) },
            navigationIcon = {
                IconButton(onClick = onNavigateBack) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onSecondaryContainer
            )
        )
        LocationDetailsContent(
            location = state.data,
            isLoading = state.loading,
            onGetInfoClick = onInfoClick,
            modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun LocationDetailsContent(
    location: Location?,
    isLoading:Boolean,
    onGetInfoClick:() -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        when {
            isLoading -> {
                Text(text = "Cargando mi pana")
            }

            location == null -> {
                Button(
                    onClick = onGetInfoClick,
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Text("Obtener informacion")
                }
            }

            else -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {

                    Spacer(modifier = Modifier.height(30.dp))
                    Text(text = location.name, style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "ID:")
                        Text(text = location.id.toString())
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Type:")
                        Text(text = location.type)

                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Dimension:")
                        Text(text = location.dimension)
                    }

                }
            }
        }
    }
}
