package com.example.data.network

import com.example.data.network.model.products.ProductDTO
import com.example.data.network.model.products.ProductsDTO
import retrofit2.Response
import retrofit2.http.GET

interface ApiDataService {
    /* these are all just github public api endpoints */
    @GET("products/2")
    suspend fun getProduct(): Response<ProductDTO>
    @GET("products")
    suspend fun getAllProducts(): Response<ProductsDTO>
}