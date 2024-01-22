package com.example.domain.repository

import com.example.data.network.model.products.Product
import com.example.data.network.model.products.Products


interface GetProductsRepository {

    suspend fun getProduct(): Product
    suspend fun getAllProducts(): Products
}