package com.example.data.network

import com.example.data.network.model.Fishes
import com.example.domain.model.products.Product
import com.example.domain.model.products.Products
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiDataService {
    /* these are all just github public api endpoints */

    @GET("species")
    suspend fun getFishes(): Response<Fishes>
    @GET("products/2")
    suspend fun getProducts(): Response<Product>
    @GET("products")
    suspend fun getAllProducts(): Response<Products>
    @GET("species/{fish}")
    suspend fun getFishDetails(@Path("fish") fishName : String): Response<Fishes>
}