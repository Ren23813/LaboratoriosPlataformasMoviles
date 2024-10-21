package com.uvg.renato.lab8.data.repository
import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "user_preferences")

class UserPreferences(context: Context) {
    private val dataStore = context.dataStore
    companion object {
        val NAME_KEY = stringPreferencesKey("user_name")
    }

    val userNameFlow: Flow<String?> = dataStore.data.map { preferences ->
        preferences[NAME_KEY]
    }

    suspend fun saveUserName(name: String) {
        dataStore.edit { preferences ->
            preferences[NAME_KEY] = name
        }
    }
}
