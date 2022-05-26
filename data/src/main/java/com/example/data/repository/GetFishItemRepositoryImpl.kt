package com.example.data.repository

import com.example.data.mappers.toDomain
import com.example.data.network.ApiDataService
import com.example.data.network.utils.SafeApiRequest
import com.example.domain.model.FishesItem
import com.example.domain.repository.GetFishItemRepository
import javax.inject.Inject

class GetFishItemRepositoryImpl @Inject constructor(private val apiService: ApiDataService): GetFishItemRepository, SafeApiRequest(){
    override suspend fun getFishes(): List<FishesItem> {
        val response = safeApiRequest { apiService.getFishes() }
        return response.toDomain()

    }

}