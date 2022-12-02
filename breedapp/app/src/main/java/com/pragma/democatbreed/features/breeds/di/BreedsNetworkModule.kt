package com.pragma.democatbreed.features.breeds.di

import com.pragma.democatbreed.features.breeds.network.services.api.IBreedsApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BreedsNetworkModule {


    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideBreedsApiClient(retrofit: Retrofit): IBreedsApiClient {
        return retrofit.create(IBreedsApiClient::class.java)
    }

}