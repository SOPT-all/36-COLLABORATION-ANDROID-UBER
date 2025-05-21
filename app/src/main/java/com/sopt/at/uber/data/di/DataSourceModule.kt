package com.sopt.at.uber.data.di

import com.sopt.at.uber.data.datasource.LocationDataSource
import com.sopt.at.uber.data.datasource.VehicleDataSource
import com.sopt.at.uber.data.datasourceimpl.LocationDataSourceImpl
import com.sopt.at.uber.data.datasourceimpl.VehicleDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindVehicleDataSource(
        impl: VehicleDataSourceImpl
    ): VehicleDataSource


    @Binds
    @Singleton
    abstract fun bindLocationDataSource(
        locationDataSourceImpl: LocationDataSourceImpl
    ) : LocationDataSource
}