package com.uvg.renato.lab8.presentation.mainFlow.character.charactersList

import com.uvg.renato.lab8.data.model.Character

data class CharacterListState(
    val isLoading: Boolean = true,
    val characters: List<Character> = emptyList(),
    val isError: Boolean = false
)