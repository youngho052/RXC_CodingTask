package com.project.rxc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.project.rxc.R
import com.project.rxc.data.api.response.GoodsListResponse
import java.text.DecimalFormat

class PriceAdapter constructor(
    private val goodsList: List<GoodsListResponse>,
    private val context: AppCompatActivity
): RecyclerView.Adapter<PriceAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.price_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val priceFormatter = DecimalFormat("#,###")
        val listItem = goodsList[position]

        if(listItem.discountRate > 0) {
            val discountTextView = TextView(context)
            discountTextView.text = "${listItem.consumerPrice}원"
        }

        holder.priceTextView.text = "${priceFormatter.format(listItem.price)}원"
    }

    override fun getItemCount(): Int {
        return goodsList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)
    }
}