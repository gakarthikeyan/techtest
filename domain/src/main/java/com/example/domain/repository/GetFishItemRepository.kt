package com.example.domain.repository

import com.example.domain.model.FishesItem
import retrofit2.Response

interface GetFishItemRepository {

    suspend fun getFishes(): List<FishesItem>
}