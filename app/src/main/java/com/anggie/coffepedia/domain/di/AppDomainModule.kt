package com.anggie.coffepedia.domain.di

import com.anggie.coffepedia.domain.repository.AppRepository
import com.anggie.coffepedia.domain.usecase.GetCoffeDetailUseCase
import com.anggie.coffepedia.domain.usecase.GetCoffeListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppDomainModule {
    @Provides
    @Singleton
    @Inject
    fun provideGetCoffeListUseCase(appRepository: AppRepository): GetCoffeListUseCase = GetCoffeListUseCase(appRepository)

    @Provides
    @Singleton
    @Inject
    fun provideGetCoffeDetailUseCase(appRepository: AppRepository): GetCoffeDetailUseCase = GetCoffeDetailUseCase(appRepository)
}