package com.pragma.democatbreed.features.breeds.network.services.api

import com.pragma.democatbreed.features.breeds.domain.models.BreedsResponse
import retrofit2.Response
import retrofit2.http.GET

interface IBreedsApiClient {

    @GET("breeds")
    suspend fun getAllBreeds() : Response<BreedsResponse>

}