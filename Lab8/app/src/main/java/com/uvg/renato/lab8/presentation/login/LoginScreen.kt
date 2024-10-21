package com.uvg.renato.lab8.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.uvg.renato.lab8.R
import com.uvg.renato.lab8.data.repository.UserPreferences
import kotlinx.coroutines.launch
import okhttp3.internal.checkOffsetAndCount


@Composable
fun LoginRoute(
    onLoginClick: () -> Unit,
) {
    LoginScreen(
        onLoginClick = onLoginClick,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier)
{
    var userName by remember{ mutableStateOf(TextFieldValue(""))}
    val coroutineScope = rememberCoroutineScope()

    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)){
        Spacer(modifier = Modifier.height(200.dp))
        Image(painter = painterResource(id = R.drawable.rick_and_morty_emblem), contentDescription = "series logo")
        TextField(value = userName, onValueChange = {userName = it}, label = { Text(text = "Nombre")})
        Button(onClick = onLoginClick , modifier = Modifier.fillMaxWidth() ) {
            Text(text = "Entrar")

        }
        Spacer(modifier = Modifier.height(225.dp))
        Text(text = "Renato Rojas - #23813")

    }
}


