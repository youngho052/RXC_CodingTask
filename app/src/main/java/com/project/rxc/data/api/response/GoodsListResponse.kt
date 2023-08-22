package com.project.rxc.data.api.response

import androidx.annotation.Keep

@Keep
data class GoodsListResponse (
    val brandName: String,
    val discountRate: Int,
    val consumerPrice: Int,
    val name: String,
    val price: Int,
    val thumbnailUrl: String
)