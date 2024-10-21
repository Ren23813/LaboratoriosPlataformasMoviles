package com.uvg.renato.lab8.data.repository

import com.uvg.renato.lab8.data.local.CharacterDb
import com.uvg.renato.lab8.data.model.Location
import com.uvg.renato.lab8.data.local.LocationDb
import com.uvg.renato.lab8.data.local.dao.CharacterDAO
import com.uvg.renato.lab8.data.local.dao.LocationDao
import com.uvg.renato.lab8.data.local.dao.mapToEntity
import com.uvg.renato.lab8.data.local.entity.mapToEntity
import com.uvg.renato.lab8.data.local.entity.mapToModel
import com.uvg.renato.lab8.data.model.Character
import com.uvg.renato.lab8.domainRepo.repository.LocationRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first


class LocalLocationRepository(
    private val locationDao: LocationDao,
    private val locationDb: LocationDb
) {
    suspend fun getLocations(): List<Location> {
        val localLocations = locationDao.getAllLocations().first() // Recolectar Flow

        return localLocations.map { localLocation -> localLocation.mapToModel()}
    }

    suspend fun populateLocalLocationsDatabase() {
        val remoteLocations = locationDb.getAllLocations()
        val localLocations = remoteLocations.map { remoteLocation ->
            remoteLocation.mapToEntity()
        }

        locationDao.insertAllLocations(localLocations)
    }
}