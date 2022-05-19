package com.example.data.repository

import com.example.data.network.ApiService
import com.example.data.network.model.Fishes
import com.example.data.network.utils.SafeApiRequest
import com.example.domain.model.FishesItem
import com.example.domain.repository.GetFishItemRepository
import retrofit2.Response
import javax.inject.Inject

class GetFishItemRepositoryImpl @Inject constructor(private val apiService: ApiService): GetFishItemRepository, SafeApiRequest(){
    override suspend fun getFishes(): List<FishesItem> {
        val response = safeApiRequest { apiService.getFishes() }
        return response

    }

}