package com.uvg.renato.lab8.domainRepo.repository

import com.uvg.renato.lab8.data.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
    suspend fun getLocationById(id: Int): Location
}


