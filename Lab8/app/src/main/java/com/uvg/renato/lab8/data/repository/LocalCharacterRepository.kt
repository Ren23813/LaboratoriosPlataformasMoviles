package com.uvg.renato.lab8.data.repository

import com.uvg.renato.lab8.data.local.CharacterDb
import com.uvg.renato.lab8.data.local.dao.CharacterDAO
import com.uvg.renato.lab8.data.local.dao.LocationDao
import com.uvg.renato.lab8.data.local.dao.mapToEntity
import com.uvg.renato.lab8.data.local.entity.mapToEntity
import com.uvg.renato.lab8.data.local.entity.mapToModel
import kotlinx.coroutines.delay
import com.uvg.renato.lab8.data.model.Character
import com.uvg.renato.lab8.domainRepo.repository.CharacterRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map


class LocalCharacterRepository(
    private val characterDao: CharacterDAO,
    private val characterDb: CharacterDb
) {
    suspend fun getCharacters(): List<Character> {
        val localCharacters = characterDao.getAllCharacters().first() // Recolectar Flow

        return localCharacters.map { localCharacter -> localCharacter.mapToModel()}
    }

    suspend fun populateLocalCharactersDatabase() {
        val remoteCharacters = characterDb.getAllCharacters()
        val localCharacters = remoteCharacters.map { remoteCharacter ->
            remoteCharacter.mapToEntity()
        }
        characterDao.insertAllCharacters(localCharacters)
    }
}