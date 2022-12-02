package com.pragma.democatbreed.features.breeds.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pragma.democatbreed.features.breeds.domain.models.Breed

import com.pragma.democatbreed.features.breeds.domain.repository.IBreedsRepository
import com.pragma.democatbreed.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreedsViewModel @Inject constructor(
    private val breedRepository: IBreedsRepository
): ViewModel() {

    private val _breedsState = mutableStateOf<Response<List<Breed>>>(Response.Success(null))
    val breedsState: State<Response<List<Breed>>> = _breedsState

    fun getAllBreeds() {
        viewModelScope.launch {
            breedRepository.getAllBreeds().collect() { response ->
                _breedsState.value = response
            }
        }
    }

}