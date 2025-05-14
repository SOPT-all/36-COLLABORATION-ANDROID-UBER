package com.sopt.at.uber.data.di

import com.sopt.at.uber.data.service.DummyUberService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun providesUberService(retrofit: Retrofit): DummyUberService =
        retrofit.create(DummyUberService::class.java)

}