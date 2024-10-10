package com.example.rickymortycoursekmp.data.remote.response

import com.example.rickymortycoursekmp.domain.model.CharacterModel
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val id: Int,
    val status: String,
    val image: String
) {

    fun toDomain(): CharacterModel {
        return CharacterModel(
            id = id.toString(),
            isAlive = status == "Alive",
            image = image
        )
    }

}