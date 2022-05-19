package com.example.data.network

import com.example.data.network.model.Fishes
import com.example.domain.model.FishesItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    /* these are all just github public api endpoints */

    @GET("species")
    suspend fun getFishes(): Response<List<FishesItem>>
    @GET("species/{fish}")
    suspend fun getFishDetails(@Path("fish") fishName : String): Response<Fishes>
}