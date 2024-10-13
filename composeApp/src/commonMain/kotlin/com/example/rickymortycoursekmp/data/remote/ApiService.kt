package com.example.rickymortycoursekmp.data.remote

import com.example.rickymortycoursekmp.data.remote.response.CharacterResponse
import com.example.rickymortycoursekmp.data.remote.response.CharactersWrapperResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiService(private val httpClient: HttpClient) {

    suspend fun getSingleCharacter(id: String): CharacterResponse {
        return httpClient.get("/api/character/$id").body<CharacterResponse>()
    }

    suspend fun getAllCharacters(page: Int): CharactersWrapperResponse {
        return httpClient.get("/api/character/") {
            parameter("page", page)
        }.body<CharactersWrapperResponse>()
    }

}