package com.sopt.at.uber.data.di

import com.sopt.at.uber.data.repositoryimpl.DummyUberRepositoryImpl
import com.sopt.at.uber.domain.repository.DummyUberRepository
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
    abstract fun bindsDummyUberRepository(
        dummyUberRepositoryImpl: DummyUberRepositoryImpl
    ): DummyUberRepository
}