package com.pragma.democatbreed.features.breeds.fragment.breed

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.pragma.democatbreed.features.breeds.domain.models.Breed
import com.pragma.democatbreed.features.breeds.fragment.breed.screen.BreedsScreen
import com.pragma.democatbreed.features.breeds.viewmodels.BreedsViewModel
import com.pragma.democatbreed.utils.Response

@Composable
fun BreedsFragment(
    breedsViewModel: BreedsViewModel = hiltViewModel()
) {

    fun launch() {
        breedsViewModel.getAllBreeds()
    }

    launch()
    Surface {
        when(val breedsListResponse = breedsViewModel.breedsState.value) {
            is Response.Loading -> {
                CircularProgressIndicator()
            }
            is Response.Success -> {
                BreedsScreen(
                    breedsList = breedsListResponse.data
                )
            }

        }
    }

}