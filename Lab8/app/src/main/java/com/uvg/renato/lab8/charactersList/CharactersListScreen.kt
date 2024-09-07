package com.uvg.renato.lab8.charactersList
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.uvg.renato.lab8.Character
import com.uvg.renato.lab8.CharacterDb


@Composable
fun CharacterListRoute(
    onCharacterClick: (Character) -> Unit,
    modifier: Modifier = Modifier
) {
    CharacterListScreen(
        onCharacterClick = onCharacterClick,
        modifier = modifier
    )
}
public val myDB = CharacterDb()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CharacterListScreen(
    onCharacterClick: (Character) -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        TopAppBar(modifier = Modifier
            .height(75.dp)
            .fillMaxWidth(),
            title = { Text(text = "Characters", style = MaterialTheme.typography.titleLarge) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
        LazyColumn(modifier.weight(0.8f)) {
            items(myDB.getAllCharacters()) { character ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .clickable { onCharacterClick(character) }
                ) {
                    Row {
                        AsyncImage(model = character.image, contentDescription = "characterImage",modifier=Modifier.clip(
                            CircleShape))
                        Column {
                            Text(
                                text = character.name,
                                modifier = Modifier
                                    .padding(start = 16.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(text = character.species +" - "+character.status, modifier = Modifier.padding(start = 16.dp), style = MaterialTheme.typography.labelMedium)
                        }
                    }
                }
            }
        }
    }
}