//package com.project.rxc.fragment
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.appcompat.app.AppCompatActivity
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.GridLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.project.rxc.adapter.GridAdapter
//import com.project.rxc.util.GridSpacingItemDecoration
//import com.project.rxc.R
//import com.project.rxc.data.api.response.GoodsListResponse
//
//class GridListFragment(
//    private val goodsList: List<GoodsListResponse>,
//    private val context: AppCompatActivity
//): Fragment() {
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var gridAdapter: GridAdapter
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        recyclerView = inflater.inflate(R.layout.fragement_girdlist, container, false) as RecyclerView
//        recyclerView.layoutManager = GridLayoutManager(context, 2)
//        recyclerView.addItemDecoration(GridSpacingItemDecoration(2, 16, true))
//
//        gridAdapter = GridAdapter(goodsList, context)
//        recyclerView.adapter = gridAdapter
//
//        return recyclerView
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    }
//}