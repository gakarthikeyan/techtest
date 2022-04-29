package com.example.techtest.api

import com.example.techtest.models.Fishes
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    /* these are all just github public api endpoints */

    @GET("species")
    suspend fun getFishes(): Fishes
    @GET("species/{fish}")
    suspend fun getFishDetails(@Path("fish") fishName : String): Fishes

}