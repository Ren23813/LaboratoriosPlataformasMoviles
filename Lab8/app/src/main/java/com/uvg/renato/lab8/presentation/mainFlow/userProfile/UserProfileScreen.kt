package com.uvg.renato.lab8.presentation.mainFlow.userProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.uvg.renato.lab8.R
import com.uvg.renato.lab8.data.source.UserPreferences


@Composable
fun UserProfileRoute(
    onLogOutClick: () -> Unit,
    userPreferences: UserPreferences
) {
    UserProfileScreen(
        modifier = Modifier.fillMaxSize(),
        onLogOutClick = onLogOutClick,
        userPreferences = userPreferences
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun UserProfileScreen(
    modifier: Modifier = Modifier,
    userPreferences: UserPreferences,
    onLogOutClick: () -> Unit
) {
    val userName by userPreferences.userName.collectAsState(initial = "No name")

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

            Text(text = "$userName", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Carné")
                Text(text = "23813")
            }
           Button(onClick = onLogOutClick) {
               Text(text = "Cerrar sesión")
           }

        }

    }
}
