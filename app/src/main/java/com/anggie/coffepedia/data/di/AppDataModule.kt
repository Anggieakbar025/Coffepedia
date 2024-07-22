package com.anggie.coffepedia.data.di

import com.anggie.coffepedia.data.remote.service.AppApiService
import com.anggie.coffepedia.data.repository.AppRepositoryImpl
import com.anggie.coffepedia.domain.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppDataModule {
    @Provides
    @Singleton
    @Inject
    fun provideAppRepository(appApiService: AppApiService): AppRepository = AppRepositoryImpl(appApiService)
}