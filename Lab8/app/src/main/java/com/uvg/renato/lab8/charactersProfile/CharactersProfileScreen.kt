package com.uvg.renato.lab8.charactersProfile
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.uvg.renato.lab8.Character
import com.uvg.renato.lab8.CharacterDb
import com.uvg.renato.lab8.ui.theme.Lab8Theme


val myCharacterDB = CharacterDb()

@Composable
fun CharacterProfileRoute(
    id: Int,
    onNavigateBack: () -> Unit,
) {
    val thisCharacter = myCharacterDB.getCharacterById(id)

    CharacterProfileScreen(
        id = id,
        name = thisCharacter.name,
        species = thisCharacter.species,
        status = thisCharacter.status,
        gender = thisCharacter.gender,
        image = thisCharacter.image,
        onNavigateBack = onNavigateBack,
        modifier = Modifier.fillMaxSize()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CharacterProfileScreen(
    id: Int,
    name: String,
    species: String,
    status: String,
    gender: String,
    image : String,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "Character Detail", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic )},
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
            , horizontalAlignment = Alignment.CenterHorizontally
            , verticalArrangement = Arrangement.Center

        ) {
            AsyncImage(model = image, contentDescription = "characterImage",modifier= Modifier
                .clip(
                    CircleShape
                )
                .size(250.dp))
            Spacer(modifier = Modifier.height(30.dp))

            Text(text = "Name: $name", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Species")
                Text(text = species)
            }
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
                Text(text = "Status:")
                Text(text = status)

            }
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Gender:")
                Text(text = gender)
            }

        }

    }
}


@Composable
fun CharacterProfileScreenPreview() {
    val character = Character(
        id = 1,
        name = "Rick Sanchez",
        species = "Human",
        status = "Alive",
        gender = "Male",
        image = "https://example.com/rick_image.jpg"
    )

    CharacterProfileScreen(
        id = character.id,
        name = character.name,
        species = character.species,
        status = character.status,
        gender = character.gender,
        image = character.image,
        onNavigateBack = {}
    )
}
@Preview
@Composable
fun CharacterProfileScreenPreviewLight() {
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme
    ) {
        CharacterProfileScreenPreview()
    }
}