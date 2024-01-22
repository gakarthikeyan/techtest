package com.example.domain.di

import com.example.data.network.ApiDataService
import com.example.domain.usecases.GetProductsUseCase
import com.example.domain.repository.GetProductsRepository
import com.example.domain.repository.GetProductsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun getProductsRepository(apiService: ApiDataService): GetProductsRepository{
        return GetProductsRepositoryImpl(apiService)
    }

    @Provides
    fun getProductsUseCase(getFishItemRepositoryImpl: GetProductsRepository): GetProductsUseCase {
        return GetProductsUseCase(getFishItemRepositoryImpl)
    }
}