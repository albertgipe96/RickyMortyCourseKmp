package com.example.rickymortycoursekmp.ui.home.tabs.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickymortycoursekmp.domain.GetRandomCharacter
import com.example.rickymortycoursekmp.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterViewModel(
    private val getRandomCharacter: GetRandomCharacter,
    private val repository: Repository
) : ViewModel() {

    private val _state = MutableStateFlow<CharactersState>(CharactersState())
    val state: StateFlow<CharactersState> = _state

    init {
        getCharacterOfTheDay()
        getAllCharacters()
    }

    private fun getCharacterOfTheDay() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                getRandomCharacter()
            }
            _state.update { state -> state.copy(characterOfTheDay = result) }
        }
    }

    private fun getAllCharacters() {
        _state.update { state ->
            state.copy(characters = repository.getAllCharacters())
        }
    }

}