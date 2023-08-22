package com.project.rxc.data.goodsList

import com.project.rxc.data.api.GoodsListService
import com.project.rxc.data.api.response.GoodsListResponse
import javax.inject.Inject

interface GoodsListRepository {
    suspend fun getGoodsList(): List<GoodsListResponse>
}

class DefaultGoodsListRepository (private val goodsListService: GoodsListService): GoodsListRepository {
    override suspend fun getGoodsList(): List<GoodsListResponse> {
        return kotlin.run {
            goodsListService.getGoodsList()
        }
    }
}
