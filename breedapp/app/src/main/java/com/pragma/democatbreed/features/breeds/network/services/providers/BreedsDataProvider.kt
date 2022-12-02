package com.pragma.democatbreed.features.breeds.network.services.providers

import com.pragma.democatbreed.features.breeds.domain.models.BreedsResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BreedsDataProvider @Inject constructor() {
    var responseGetBreeds: BreedsResponse = BreedsResponse(emptyList(), Operation("",""))
}