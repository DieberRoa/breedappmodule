package com.pragma.democatbreed.features.breeds.network.repository

import com.pragma.democatbreed.features.breeds.domain.models.Breed
import com.pragma.democatbreed.features.breeds.domain.repository.IBreedsRepository
import com.pragma.democatbreed.features.breeds.network.services.api.BreedsService
import com.pragma.democatbreed.features.breeds.network.services.providers.BreedsDataProvider
import com.pragma.democatbreed.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class BreedsRepository @Inject constructor(
    private val service: BreedsService,
    private val stuffDataProvider: BreedsDataProvider
): IBreedsRepository{

    override suspend fun getAllBreeds() : Flow<Response<List<Breed>>> =
        flow {
            try{
                emit(Response.Loading)
                val responseApi = service.getAllBreeds().data;
                emit(Response.Success(responseApi))
            } catch (e: java.lang.Exception) {
                emit(Response.Failure(e))
            }
        }.flowOn(Dispatchers.IO)

}