package com.project.rxc.domain.goodsList

import com.project.rxc.data.api.response.GoodsListResponse
import com.project.rxc.data.goodsList.GoodsListRepository
import com.project.rxc.di.IODispatcher
import com.project.rxc.domain.FlowUseCase
import com.project.rxc.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GoodsListUseCase @Inject constructor(
    private val goodsListRepository: GoodsListRepository,
    @IODispatcher ioDispatcher: CoroutineDispatcher
): FlowUseCase<Unit, List<GoodsListResponse>>(ioDispatcher){
    override fun execute(parameters: Unit): Flow<Result<List<GoodsListResponse>>> = flow {
        emit(Result.Loading)
        emit(Result.Success(goodsListRepository.getGoodsList()))
    }
}