package com.example.domain.usecases

import com.example.common.Resource
import com.example.domain.model.Products
import com.example.domain.repository.GetProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GetProductsUseCase{
    suspend operator fun invoke(): Flow<Resource<Products>>
}