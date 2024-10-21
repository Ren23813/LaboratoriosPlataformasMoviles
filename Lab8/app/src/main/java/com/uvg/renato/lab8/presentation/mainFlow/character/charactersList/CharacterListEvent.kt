package com.uvg.renato.lab8.presentation.mainFlow.character.charactersList

sealed interface CharacterListEvent {
    data object ForceError: CharacterListEvent
    data object RetryClick: CharacterListEvent
}