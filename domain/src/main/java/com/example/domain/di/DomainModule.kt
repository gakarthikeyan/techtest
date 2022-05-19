package com.example.domain.di

import com.example.domain.repository.GetFishItemRepository
import com.example.domain.usecases.GetFishItemUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun provideGetFishItemUseCase(getFishItemRepository: GetFishItemRepository): GetFishItemUseCase{
        return GetFishItemUseCase(getFishItemRepository)
    }
}