package com.example.rickymortycoursekmp.domain

import com.example.rickymortycoursekmp.domain.model.CharacterModel

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
}