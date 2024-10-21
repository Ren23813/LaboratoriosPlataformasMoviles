package com.uvg.renato.lab8.domainRepo.repository

import com.uvg.renato.lab8.data.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
    suspend fun getCharacterById(id: Int): Character
}