package com.example.rickymortycoursekmp.domain

import com.example.rickymortycoursekmp.domain.model.CharacterModel

class GetRandomCharacter(
    private val repository: Repository
) {

    suspend operator fun invoke(): CharacterModel {
        val randomId: Int = (1..826).random()
        return repository.getSingleCharacter(randomId.toString())
    }

}