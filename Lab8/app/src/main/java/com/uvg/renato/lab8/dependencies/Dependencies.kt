package com.uvg.renato.lab8.dependencies

import android.content.Context
import androidx.room.Room
import com.uvg.renato.lab8.data.local.AppDatabase
import com.uvg.renato.lab8.data.local.dao.CharacterDAO
import com.uvg.renato.lab8.data.local.dao.LocationDao
import com.uvg.renato.lab8.domainRepo.repository.CharacterRepository
import com.uvg.renato.lab8.domainRepo.repository.CharacterRepositoryImpl
import com.uvg.renato.lab8.domainRepo.repository.LocationRepository
import com.uvg.renato.lab8.domainRepo.repository.LocationRepositoryImpl

//Room dependencies
object Dependencies {
    @Volatile
    private var database: AppDatabase? = null

    private fun buildDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "full.db"
        ).build()
    }

    fun provideDatabase(context: Context): AppDatabase {
        return database ?: synchronized(this) {
            database ?: buildDatabase(context).also { database = it }
        }
    }

    fun provideLocationDao(context: Context): LocationDao {
        return provideDatabase(context).locationDao() // Obtener LocationDao de la base de datos
    }

    fun provideCharacterDao(context: Context): CharacterDAO {
        return provideDatabase(context).characterDao() // Obtener CharacterDao de la base de datos
    }

    fun provideLocationRepository(context: Context): LocationRepository {
        val locationDao = provideLocationDao(context)
        return LocationRepositoryImpl(locationDao) // Usamos la implementación concreta
    }


    fun provideCharacterRepository(context: Context): CharacterRepository {
        val characterDao = provideCharacterDao(context)
        return CharacterRepositoryImpl(characterDao) // Crear el repositorio con el DAO inyectado
    }
}
