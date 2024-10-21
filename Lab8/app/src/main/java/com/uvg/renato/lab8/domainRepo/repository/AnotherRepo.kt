package com.uvg.renato.lab8.domainRepo.repository

import com.uvg.renato.lab8.data.local.CharacterDb
import com.uvg.renato.lab8.data.local.LocationDb
import com.uvg.renato.lab8.data.local.dao.CharacterDAO
import com.uvg.renato.lab8.data.local.dao.LocationDao
import com.uvg.renato.lab8.data.local.dao.mapToEntity
import com.uvg.renato.lab8.data.local.entity.mapToEntity
import com.uvg.renato.lab8.data.local.entity.mapToModel
import com.uvg.renato.lab8.data.model.Character
import com.uvg.renato.lab8.data.model.Location
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class LocationRepositoryImpl(
    private val locationDao: LocationDao
) : LocationRepository {

    override suspend fun getLocations(): List<Location> {
        val locationdb = LocationDb()
        val remoteLocations = locationdb.getAllLocations()
        val localLocations = remoteLocations.map { location -> location.mapToEntity()
        }
        locationDao.insertAllLocations(localLocations)

        return locationDao.getAllLocations()
            .first()
            .map{entity -> entity.mapToModel()}
    }

    override suspend fun getLocationById(id: Int): Location {
        val entity = locationDao.getLocationID(id)
        return entity?.mapToModel() ?: throw IllegalArgumentException("Error. Location not found")
    }

    suspend fun insertLocations(locations: List<Location>) {
        val entities = locations.map { it.mapToEntity() }
        locationDao.insertAllLocations(entities)
    }
}


class CharacterRepositoryImpl(
    private val characterDAO: CharacterDAO
) : CharacterRepository {

    override suspend fun getCharacters(): List<Character> {
        val characterdb = CharacterDb()
        val remoteCharacters = characterdb.getAllCharacters()
        val localCharacters = remoteCharacters.map { character -> character.mapToEntity()
        }
        characterDAO.insertAllCharacters(localCharacters)

        return characterDAO.getAllCharacters()
            .first()
            .map{entity -> entity.mapToModel()}
    }

    override suspend fun getCharacterById(id: Int): Character {
        val entity = characterDAO.getCharacterID(id)
        return entity?.mapToModel() ?: throw IllegalArgumentException("Character not found")
    }

    suspend fun insertAllCharacters(characters: List<Character>) {

        val entities = characters.map { it.mapToEntity() }
        characterDAO.insertAllCharacters(entities)
    }
}