package com.sopt.at.uber.data.di

import com.sopt.at.uber.data.service.LocationService
import com.sopt.at.uber.data.service.VehicleService
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
    fun providesVehicleService(retrofit: Retrofit): VehicleService =
        retrofit.create(VehicleService::class.java)

    @Provides
    @Singleton
    fun providesLocationService(retrofit: Retrofit): LocationService =
        retrofit.create(LocationService::class.java)


}