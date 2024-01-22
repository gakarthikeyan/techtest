package com.example.domain.usecases

import com.example.common.Resource
import com.example.data.network.model.products.Products
import com.example.domain.repository.GetProductsRepository
import com.example.domain.repository.GetProductsRepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val getProductsRepositoryImpl: GetProductsRepository){

//    operator fun invoke(): Flow<Resource<List<FishesItem>>> = flow {
    operator fun invoke(): Flow<Resource<Products>> = flow {
        emit(Resource.Loading(null))
        try{

//            val response = getFishItemRepository.getProduct()
            val response = getProductsRepositoryImpl.getAllProducts()
            emit(Resource.Success(response))

        }catch (e: Exception){
            emit(Resource.Error("Error Occurred"))
        }
    }
}