package com.project.rxc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.project.rxc.data.api.response.GoodsListResponse
import androidx.lifecycle.viewModelScope
import com.project.rxc.data.api.GoodsListService
import com.project.rxc.domain.goodsList.GoodsListUseCase
import com.project.rxc.result.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class GoodsListViewModel @Inject constructor(
    private val getGoodsListUseCase: GoodsListUseCase,
): ViewModel() {
    private val _goodsListUiState: MutableLiveData<GoodsListUiState> =
        MutableLiveData(GoodsListUiState())

    val goodsListUiState: LiveData<GoodsListUiState>
        get() = _goodsListUiState

    init {
        getGoodsListItem()
    }

    private fun getGoodsListItem() = viewModelScope.launch {
        getGoodsListUseCase(Unit).collectLatest {
            if(it is Result.Success) {
                _goodsListUiState.value = _goodsListUiState.value!!.copy(
                    goodsList = it.data
                )
            }
        }
    }
}

data class GoodsListUiState (
    val goodsList: List<GoodsListResponse> = listOf(),
)

data class LikedGoodsListResponse(
    val goodsListResponse: GoodsListResponse,
    var like: Boolean
)
