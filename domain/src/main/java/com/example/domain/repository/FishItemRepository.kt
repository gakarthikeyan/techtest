package com.example.domain.repository

import com.example.domain.model.FishesItem
import retrofit2.Response

interface FishItemRepository {
    suspend fun getFishes(): Response<List<FishesItem>>
}