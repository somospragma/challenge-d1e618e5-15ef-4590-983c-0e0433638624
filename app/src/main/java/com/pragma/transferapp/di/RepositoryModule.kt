package com.pragma.transferapp.di

import com.pragma.transferapp.data.repository.TransferRepository
import com.pragma.transferapp.data.repository.TransferRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTransferRepository(transferRepositoryImpl: TransferRepositoryImpl): TransferRepository {
        return transferRepositoryImpl
    }

    @Provides
    @Singleton
    fun provideTransferRepositoryImpl(): TransferRepositoryImpl {
        return TransferRepositoryImpl()
    }
}