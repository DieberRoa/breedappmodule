package com.pragma.democatbreed.features.breeds.domain.models

import com.google.gson.annotations.SerializedName

data class BreedsResponse (
    @SerializedName("data") val data: List<Breed>,
    @SerializedName("operation") val operation : Operation
)
