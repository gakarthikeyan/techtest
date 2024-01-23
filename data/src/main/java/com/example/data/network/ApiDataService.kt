package com.example.data.network

import com.example.data.network.model.products.ProductEntity
import com.example.data.network.model.products.ProductsEntity
import retrofit2.Response
import retrofit2.http.GET

interface ApiDataService {
    /* these are all just github public api endpoints */
    @GET("products/2")
    suspend fun getProduct(): Response<ProductEntity>
    @GET("products")
    suspend fun getAllProducts(): Response<ProductsEntity>
}