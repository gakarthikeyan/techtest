package com.example.data.usecase

import com.example.common.Resource
import com.example.domain.model.Products
import com.example.domain.repository.GetProductsRepository
import com.example.domain.usecases.GetProductsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductsUseCaseImpl @Inject constructor(private val getProductsRepositoryImpl: GetProductsRepository): GetProductsUseCase{

    override suspend operator fun invoke(): Flow<Resource<Products>> = flow {
        emit(Resource.Loading(null))
        try{

            val response = getProductsRepositoryImpl.getAllProducts()
            emit(Resource.Success(response))

        }catch (e: Exception){
            emit(Resource.Error("Error Occurred"))
        }
    }
}