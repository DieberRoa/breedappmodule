package com.pragma.democatbreed.features.breeds.fragment.breed.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.pragma.democatbreed.features.breeds.domain.models.Breed
import com.pragma.democatbreed.utils.Response


@Composable
fun BreedsScreen(
    breedsList: List<Breed>? = null
) {
    if (breedsList == null) return
    LazyColumn {
        items(breedsList.count()) { item ->
            breedsList[item].let { breed ->
                Card {
                    breed.name?.let { Text(it) }
                }
            }
        }
    }
}


