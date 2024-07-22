package com.anggie.coffepedia.data.remote.di

import com.anggie.coffepedia.data.remote.service.AppApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppRemoteDataModule {
    @Provides
    @Singleton
    @Inject
    fun provideAppApiService(retrofit: Retrofit): AppApiService = retrofit.create(AppApiService::class.java)
}