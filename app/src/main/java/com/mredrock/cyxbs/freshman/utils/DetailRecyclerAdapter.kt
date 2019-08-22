package com.mredrock.cyxbs.freshman.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.mredrock.cyxbs.freshman.R

import java.util.ArrayList

class DetailRecyclerAdapter(
    private val images: List<String>,
    private val contents: List<String>,
    private val context: Context
) : RecyclerView.Adapter<DetailRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.app_detail_how_recycler_item, parent, false)

        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(images[position]).into(holder.image)
        holder.num.text = (position + 1).toString() + "."
        holder.content.text = contents[position]
    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var num: TextView
        internal var content: TextView
        internal var image: ImageView

        init {
            num = itemView.findViewById<View>(R.id.tv_detail_how_item_num) as TextView
            content = itemView.findViewById<View>(R.id.tv_detail_how_item_content) as TextView
            image = itemView.findViewById<View>(R.id.iv_detail_how_item) as ImageView
        }
    }
}
