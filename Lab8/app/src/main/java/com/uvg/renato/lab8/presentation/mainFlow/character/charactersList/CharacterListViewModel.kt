package com.uvg.renato.lab8.presentation.mainFlow.character.charactersList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.uvg.renato.lab8.data.local.dao.CharacterDAO
import com.uvg.renato.lab8.data.local.entity.mapToModel
import com.uvg.renato.lab8.data.model.Character
import com.uvg.renato.lab8.dependencies.Dependencies
import com.uvg.renato.lab8.domainRepo.repository.CharacterRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class CharacterListViewModel(
    private val characterDAO: CharacterDAO,
    private val characterRepository: CharacterRepository
) : ViewModel() {
    val characters = characterDAO.getAllCharacters()
        .map { entities -> entities.map { it.mapToModel() } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )


    private var getDataJob: Job? = null
    private val _state: MutableStateFlow <CharacterListState> = MutableStateFlow(CharacterListState())
    val state = _state.asStateFlow()

    init {

        getCharacters()
    }


    fun onEvent(event: CharacterListEvent) {
        when (event) {

            CharacterListEvent.ForceError -> {
                getDataJob?.cancel()
                _state.update { state ->
                    state.copy(
                        isLoading = false,
                        isError = true
                    )
                }
            }
            CharacterListEvent.RetryClick -> {
                getCharacters()
            }
        }
    }

    private fun getCharacters() {

        getDataJob = viewModelScope.launch {
            _state.update { state ->
                state.copy(
                    isLoading = true,
                    isError = false
                )
            }

            val characters = characterRepository.getCharacters()

            _state.update { state ->
                state.copy(
                    isLoading = false,
                    characters = characters
                )
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = checkNotNull(this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                val repositoryDao = Dependencies.provideDatabase(application)
                val repository = Dependencies.provideCharacterRepository(application)
                CharacterListViewModel(repositoryDao.characterDao(),repository)
            }
        }
    }
}