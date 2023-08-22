package com.project.rxc.di

import com.project.rxc.data.api.*
import com.project.rxc.data.goodsList.DefaultGoodsListRepository
import com.project.rxc.data.goodsList.GoodsListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Provides
    @Singleton
    fun goodsListRepository (
        service: GoodsListService
    ): GoodsListRepository {
        return DefaultGoodsListRepository(
            service
        )
    }
}