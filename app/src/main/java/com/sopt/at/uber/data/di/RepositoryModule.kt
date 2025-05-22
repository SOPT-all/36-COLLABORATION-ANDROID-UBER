package com.sopt.at.uber.data.di

import com.sopt.at.uber.data.repositoryimpl.LocationRepositoryImpl
import com.sopt.at.uber.data.repositoryimpl.VehicleRepositoryImpl
import com.sopt.at.uber.domain.repository.LocationRepository
import com.sopt.at.uber.domain.repository.VehicleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsVehicleRepository(
        vehicleRepositoryImpl: VehicleRepositoryImpl
    ): VehicleRepository


    @Binds
    @Singleton
    abstract fun bindLocationRepository(
        locationRepositoryImpl: LocationRepositoryImpl
    ) : LocationRepository
}