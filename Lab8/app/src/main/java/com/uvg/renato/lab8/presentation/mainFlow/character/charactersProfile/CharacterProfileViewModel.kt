package com.uvg.renato.lab8.presentation.mainFlow.character.charactersProfile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.toRoute
import com.uvg.renato.lab8.data.repository.LocalCharacterRepository
import com.uvg.renato.lab8.dependencies.Dependencies
import com.uvg.renato.lab8.domainRepo.repository.CharacterRepository
import com.uvg.renato.lab8.presentation.mainFlow.location.locationDetails.LocationDetailsViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterProfileViewModel(
    private val characterRepository: CharacterRepository,
    savedStateHandle: SavedStateHandle ): ViewModel() {
    private val characterProfile = savedStateHandle.toRoute<CharactersProfileDestination>()
    private val _state: MutableStateFlow<CharacterProfileState> = MutableStateFlow(CharacterProfileState())
    val state = _state.asStateFlow()

    init {
        getCharacterData()
    }

    private fun getCharacterData() {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(isLoading = true)
            }

            val character = characterRepository.getCharacterById(characterProfile.characterId)

            _state.update { state ->
                state.copy(
                    data = character,
                    isLoading = false
                )
            }

        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = checkNotNull(this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                val repository = Dependencies.provideCharacterRepository(application)
                val savedStateHandle = this.createSavedStateHandle()
                CharacterProfileViewModel(repository, savedStateHandle)
            }
        }
}
    }
