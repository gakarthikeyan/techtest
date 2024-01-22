package com.example.data.usecases

import com.example.common.Resource
import com.example.data.repository.GetFishItemRepositoryImpl
import com.example.data.network.model.products.ProductDTO
import com.example.domain.model.products.Product
import com.example.domain.model.products.Products
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetFishItemUseCase @Inject constructor(private val getFishItemRepository: GetFishItemRepositoryImpl){

//    operator fun invoke(): Flow<Resource<List<FishesItem>>> = flow {
    operator fun invoke(): Flow<Resource<Products>> = flow {
        emit(Resource.Loading(null))
//        try{

//            val response = getFishItemRepository.getFishes()
//            val response = getFishItemRepository.getProduct()
            val response = getFishItemRepository.getAllProducts()
            emit(Resource.Success(response))

        /*}catch (e: Exception){
            emit(Resource.Error("Error Occurred"))
        }*/
    }
}