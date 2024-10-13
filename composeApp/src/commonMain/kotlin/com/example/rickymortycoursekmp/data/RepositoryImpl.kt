package com.example.rickymortycoursekmp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickymortycoursekmp.data.remote.ApiService
import com.example.rickymortycoursekmp.data.remote.paging.CharactersPagingSource
import com.example.rickymortycoursekmp.domain.Repository
import com.example.rickymortycoursekmp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val apiService: ApiService,
    private val charactersPagingSource: CharactersPagingSource
) : Repository {

    companion object {
        private const val MAX_ITEMS = 20
        private const val PREFETCH_ITEMS = 20
    }

    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return apiService.getSingleCharacter(id).toDomain()
    }

    override fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = { charactersPagingSource }
        ).flow
    }

}