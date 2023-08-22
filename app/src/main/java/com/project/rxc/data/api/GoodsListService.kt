package com.project.rxc.data.api

import com.project.rxc.data.api.response.GoodsListResponse
import retrofit2.http.GET

interface GoodsListService {
    @GET("goodslist.json")
    suspend fun getGoodsList(): List<GoodsListResponse>
}