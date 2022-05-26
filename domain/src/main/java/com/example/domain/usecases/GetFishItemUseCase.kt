package com.example.domain.usecases

import com.example.common.Resource
import com.example.domain.model.FishesItem
import com.example.domain.repository.GetFishItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetFishItemUseCase @Inject constructor(private val getFishItemRepository: GetFishItemRepository){

    operator fun invoke(): Flow<Resource<List<FishesItem>>> = flow {
        emit(Resource.Loading(null))
        try{

            val response = getFishItemRepository.getFishes()
            emit(Resource.Success(data = response))

        }catch (e: Exception){
            emit(Resource.Error("Error Occurred"))
        }

    }
}