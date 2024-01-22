package com.example.domain.repository

import com.example.domain.model.FishesItem
import com.example.domain.model.products.Product
import com.example.domain.model.products.Products

interface GetFishItemRepository {

    suspend fun getFishes(): List<FishesItem>
    suspend fun getProduct(): Product
    suspend fun getAllProducts(): Products
}