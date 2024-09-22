package com.uvg.renato.lab8.userProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.uvg.renato.lab8.CharacterDb
import com.uvg.renato.lab8.R


@Composable
fun UserProfileRoute(
    onButtonClick: () -> Unit,
    modifier: Modifier
) {
    UserProfileScreen(
        modifier = modifier.fillMaxSize(),
        onButtonClick = onButtonClick
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun UserProfileScreen(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit
) {
    var selectedItem by remember { mutableStateOf(0) }

    Column(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
            , horizontalAlignment = Alignment.CenterHorizontally
            , verticalArrangement = Arrangement.Center

        ) {
            Image(painter = painterResource(id = R.drawable.cat), contentDescription = "me irl",modifier=Modifier.clip(
                CircleShape))
            Spacer(modifier = Modifier.height(30.dp))

            Text(text = "Renato Manuel Rojas Roldan", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Carné")
                Text(text = "23813")
            }
           Button(onClick = onButtonClick) { //navegar al login; limpiar backstack
               Text(text = "Cerrar sesión")
           }

        }

    }
}
