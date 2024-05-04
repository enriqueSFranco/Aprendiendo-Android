package com.kikesf.aprendiendoandroid.marvelApp.services

import com.kikesf.aprendiendoandroid.marvelApp.models.SuperHero
import com.kikesf.aprendiendoandroid.marvelApp.utils.Constants
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/v1/public/characters")
    suspend fun getSuperheros(
        @Query("name")name: String,
        @Query("ts")ts: String = Constants.timestamp,
        @Query("apikey")apiKey: String = Constants.PUBLIC_KEY,
        @Query("hash")hash: String = Constants.hash()
    ): Response<SuperHero>
}

object RetrofitServiceFactory {
    fun makeRetrofitService(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}