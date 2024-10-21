package com.uvg.renato.lab8.presentation.mainFlow.character.charactersProfile

import com.uvg.renato.lab8.data.model.Character

data class CharacterProfileState(
    val data: Character? = null,
    val isLoading: Boolean = true
)
