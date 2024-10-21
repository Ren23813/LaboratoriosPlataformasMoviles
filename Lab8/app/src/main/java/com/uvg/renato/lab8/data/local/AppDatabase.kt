package com.uvg.renato.lab8.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uvg.renato.lab8.data.local.dao.*
import com.uvg.renato.lab8.data.local.entity.*


@Database(
    entities = [
        CharacterEntity::class,
        LocationEntity::class
    ],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun characterDao(): CharacterDAO
    abstract fun locationDao(): LocationDao
}