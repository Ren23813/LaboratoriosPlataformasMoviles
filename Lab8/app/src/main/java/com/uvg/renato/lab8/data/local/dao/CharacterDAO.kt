package com.uvg.renato.lab8.data.local.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uvg.renato.lab8.data.local.entity.CharacterEntity
import com.uvg.renato.lab8.data.local.entity.LocationEntity
import com.uvg.renato.lab8.data.model.Character
import com.uvg.renato.lab8.data.model.Location
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDAO {
    @Query("SELECT * FROM CharacterEntity")
    fun getAllCharacters(): Flow<List<CharacterEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCharacters(characters: List<CharacterEntity>)

    @Query("SELECT * FROM CharacterEntity WHERE id = :characterID LIMIT 1")
    suspend fun getCharacterID(characterID: Int): CharacterEntity?
}

fun Character.mapToEntity(): CharacterEntity {
    return CharacterEntity(
        id = this.id,
        name = this.name,
        status = this.status,
        species = this.species,
        gender = this.gender,
        image = this.image
    )
}