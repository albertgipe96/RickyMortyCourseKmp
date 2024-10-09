package com.example.rickymortycoursekmp.data.remote

import com.example.rickymortycoursekmp.data.remote.response.CharacterResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService(private val httpClient: HttpClient) {

    suspend fun getSingleCharacter(id: String): CharacterResponse {
        return httpClient.get("/api/character/$id").body<CharacterResponse>()
    }

}