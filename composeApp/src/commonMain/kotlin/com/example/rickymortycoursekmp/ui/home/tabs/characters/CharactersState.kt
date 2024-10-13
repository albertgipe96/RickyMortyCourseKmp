package com.example.rickymortycoursekmp.ui.home.tabs.characters

import androidx.paging.PagingData
import com.example.rickymortycoursekmp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class CharactersState(
    val characterOfTheDay: CharacterModel? = null,
    val characters: Flow<PagingData<CharacterModel>> = emptyFlow()
)