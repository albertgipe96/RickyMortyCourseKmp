package com.example.rickymortycoursekmp.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val id: Int,
    val status: String,
    val image: String
)