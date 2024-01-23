package com.example.domain.repository

import com.example.domain.model.Product
import com.example.domain.model.Products


interface GetProductsRepository {

    suspend fun getProduct(): Product
    suspend fun getAllProducts(): Products
}