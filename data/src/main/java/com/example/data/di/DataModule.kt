package com.example.data.di

import com.example.data.mappers.ProductDomainModelMapper
import com.example.data.mappers.ProductsDomainModelMapper
import com.example.data.network.ApiDataService
import com.example.data.repository.GetProductsRepositoryImpl
import com.example.data.usecase.GetProductsUseCaseImpl
import com.example.domain.repository.GetProductsRepository
import com.example.domain.usecases.GetProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun getProductsRepository(apiService: ApiDataService,
                              productsDomainModelMapper: ProductsDomainModelMapper,
                              productDomainModelMapper: ProductDomainModelMapper): GetProductsRepository{
        return GetProductsRepositoryImpl(apiService, productsDomainModelMapper, productDomainModelMapper)
    }

    @Provides
    fun getProductsUseCase(getProductsRepositoryImpl: GetProductsRepository): GetProductsUseCase {
        return GetProductsUseCaseImpl(getProductsRepositoryImpl)
    }
}