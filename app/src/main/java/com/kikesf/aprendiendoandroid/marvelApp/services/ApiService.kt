package com.kikesf.aprendiendoandroid.marvelApp.services

import com.kikesf.aprendiendoandroid.marvelApp.models.SuperHero
import com.kikesf.aprendiendoandroid.marvelApp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/v1/public/characters?name=thor&ts=1&apikey=1342ee46b3a8207e80b268dc4b8f97a1&hash=e7538208ae63bf14cfdf1c6e4ecded44")
    suspend fun getSuperheros(
        @Path("name")name: String,
        @Query("ts")ts: String = Constants.timestamp,
        @Query("apiKey")apiKey: String = Constants.PUBLIC_KEY,
        @Query("hash")hash: String = Constants.hash()
    ): Response<SuperHero>
}