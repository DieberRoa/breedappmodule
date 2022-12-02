package com.pragma.democatbreed.features.breeds.domain.repository

import com.pragma.democatbreed.features.breeds.domain.models.Breed
import com.pragma.democatbreed.utils.Response
import kotlinx.coroutines.flow.Flow

interface IBreedsRepository {
    suspend fun getAllBreeds() : Flow<Response<List<Breed>>>
}