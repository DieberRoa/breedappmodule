package com.pragma.democatbreed.features.breeds.network.services.api

import com.pragma.democatbreed.features.breeds.domain.models.BreedsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BreedsService @Inject constructor(private val api: IBreedsApiClient) {

    suspend fun getAllBreeds() : BreedsResponse {
        return withContext(Dispatchers.IO) {
            val response = api.getAllBreeds()
            response.body() ?: BreedsResponse(emptyList(), Operation("",""))
        }
    }
}