package com.uvg.renato.lab8.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.renato.lab8.*
import com.uvg.renato.lab8.ui.theme.Lab8Theme

@Composable
fun LoginRoute(
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LoginScreen(
        onButtonClick = onButtonClick,
        modifier = modifier
    )
}


@Composable
fun LoginScreen(
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier)
{
    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize().padding(10.dp)){
        Spacer(modifier = Modifier.height(200.dp))
        Image(painter = painterResource(id = R.drawable.rick_and_morty_emblem), contentDescription = "series logo")
        Button(onClick = onButtonClick , modifier = Modifier.fillMaxWidth() ) {
            Text(text = "Entrar")

        }
        Spacer(modifier = Modifier.height(225.dp))
        Text(text = "Renato Rojas - #23813")

    }
}

@Preview
@Composable
fun previewLoginScreen(){
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(50.dp)) {
    }
    Lab8Theme {
        LoginScreen(onButtonClick = {  })
    }
}
