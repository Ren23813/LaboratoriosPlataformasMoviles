package com.uvg.renato.lab8.data.source
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferences(private val dataStore: DataStore<Preferences>) {

    private val NAME_KEY = stringPreferencesKey("user_name")

    val userName: Flow<String?> = dataStore.data
        .map { preferences ->
            preferences[NAME_KEY]
        }

    suspend fun saveUserName(name: String) {
        dataStore.edit { preferences ->
            preferences[NAME_KEY] = name
        }
    }
}

