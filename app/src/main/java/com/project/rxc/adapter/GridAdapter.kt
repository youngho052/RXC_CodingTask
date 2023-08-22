package com.project.rxc.adapter

import android.graphics.Paint
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.rxc.LikedGoodsListResponse
import com.project.rxc.R
import java.text.DecimalFormat

class GridAdapter(
    private val goodsList: List<LikedGoodsListResponse>,
    private val context: AppCompatActivity
) : RecyclerView.Adapter<GridAdapter.ViewHolder>() {
    private val priceFormatter = DecimalFormat("#,###")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.gridlist_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = goodsList[position]

        holder.likeImageView.setOnClickListener {
            listItem.like = !listItem.like
            notifyDataSetChanged()
        }

        holder.nameTextView.text = listItem.goodsListResponse.name
        holder.priceTextView.text = "${priceFormatter.format(listItem.goodsListResponse.price)}원"
        Glide
            .with(context)
            .load(listItem.goodsListResponse.thumbnailUrl)
            .placeholder(R.drawable.placeholder_image)
            .into(holder.imageView)

        holder.likeBind(listItem.like)

        if(listItem.goodsListResponse.discountRate > 0) {
            holder.rateBind(
                rate ="${listItem.goodsListResponse.discountRate}%",
                consumerPrice = "${priceFormatter.format(listItem.goodsListResponse.consumerPrice)}원"
            )

            holder.priceView.removeView(holder.priceTextView)
            holder.priceView.addView(holder.discountRateView)
            holder.priceView.addView(holder.priceTextView)
            holder.listItemView.addView(holder.consumerPriceView)
        } else {
            holder.priceView.removeView(holder.discountRateView)
            holder.listItemView.removeView(holder.consumerPriceView)
        }

    }

    override fun getItemCount(): Int {
        return goodsList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)
        val listItemView: LinearLayout = itemView.findViewById(R.id.listItemView)
        val priceView: LinearLayout = itemView.findViewById(R.id.priceView)
        val likeImageView: ImageView = itemView.findViewById(R.id.likeImageView)
        val discountRateView: TextView = TextView(context)
        val consumerPriceView = TextView(context)

        fun likeBind(like: Boolean) {
            if(like) {
                likeImageView.setImageResource(R.drawable.ic_like_filled)
            } else {
                likeImageView.setImageResource(R.drawable.ic_like)
            }
        }

        fun rateBind(rate: String, consumerPrice: String) {
            priceView.removeView(discountRateView)
            listItemView.removeView(consumerPriceView)

            setDisCountRate(rate)
            setConsumerPrice(consumerPrice)
        }

        private fun setDisCountRate(rate: String) {
            discountRateView.text = rate
            discountRateView.textSize = 16f
            discountRateView.setTextColor(ContextCompat.getColor(context, R.color.red))
            discountRateView.setTextAppearance(R.style.BoldTextStyle)
        }

        private fun setConsumerPrice(consumerPrice: String) {
            consumerPriceView.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            consumerPriceView.gravity = Gravity.CENTER
            consumerPriceView.alpha = 0.5f
            consumerPriceView.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            consumerPriceView.text = consumerPrice
            consumerPriceView.textSize = 12f
            consumerPriceView.setTextColor(ContextCompat.getColor(context, R.color.black))
            consumerPriceView.setTextAppearance(R.style.RegularTextStyle)
        }
    }
}