package com.uvg.renato.lab8.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uvg.renato.lab8.data.local.entity.LocationEntity
import com.uvg.renato.lab8.data.model.Location
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {
    @Query("SELECT * FROM LocationEntity")
    fun getAllLocations(): Flow<List<LocationEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllLocations(locations: List<LocationEntity>)

    @Query("SELECT * FROM LocationEntity WHERE id = :locationID LIMIT 1")
    suspend fun getLocationID(locationID: Int): LocationEntity?
}
