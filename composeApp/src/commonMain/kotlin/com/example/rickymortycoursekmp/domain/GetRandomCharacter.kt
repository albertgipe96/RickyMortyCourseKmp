package com.example.rickymortycoursekmp.domain

class GetRandomCharacter(
    private val repository: Repository
) {

    suspend operator fun invoke() {
        val randomId: Int = (1..826).random()
        repository.getSingleCharacter(randomId.toString())
    }

}