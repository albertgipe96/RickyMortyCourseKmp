package com.example.rickymortycoursekmp.data

import com.example.rickymortycoursekmp.data.remote.ApiService
import com.example.rickymortycoursekmp.domain.Repository
import com.example.rickymortycoursekmp.domain.model.CharacterModel

class RepositoryImpl(
    private val apiService: ApiService
) : Repository {

    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return apiService.getSingleCharacter(id).toDomain()
    }

}