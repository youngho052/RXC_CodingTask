package com.project.rxc

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.rxc.adapter.GridAdapter
import com.project.rxc.data.api.response.GoodsListResponse
import com.project.rxc.util.GridSpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var gridAdapter: GridAdapter
    private val goodsListViewModel: GoodsListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goodsList:MutableList<LikedGoodsListResponse> = mutableListOf()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.addItemDecoration(GridSpacingItemDecoration(16))

        goodsListViewModel.goodsListUiState.observe(this) {
            repeat(it.goodsList.size) { idx->
                goodsList.add(
                    LikedGoodsListResponse(it.goodsList[idx], false)
                )
            }

            gridAdapter = GridAdapter(goodsList, this)
            recyclerView.adapter = gridAdapter
        }
    }
}

