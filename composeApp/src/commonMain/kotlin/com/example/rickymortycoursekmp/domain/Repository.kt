package com.example.rickymortycoursekmp.domain

import androidx.paging.PagingData
import com.example.rickymortycoursekmp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
    fun getAllCharacters(): Flow<PagingData<CharacterModel>>
}