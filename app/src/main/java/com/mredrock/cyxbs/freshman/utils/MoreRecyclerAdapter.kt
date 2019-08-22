package com.mredrock.cyxbs.freshman.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mredrock.cyxbs.freshman.R

class MoreRecyclerAdapter(
    private val images :List<String>,
    private val names:List<String>,
    private val contents: List<String>,
    private val context: Context
) :RecyclerView.Adapter<MoreRecyclerAdapter.ViewHolder>(){



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoreRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.app_star_recyler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: MoreRecyclerAdapter.ViewHolder, position: Int) {
        holder.name.text = names[position]
        holder.content.text = contents[position]
        Glide.with(context).load(images[position]).into(holder.imageView)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var name: TextView
        internal var content: TextView
        internal var imageView: ImageView

        init {
            name = itemView.findViewById(R.id.star_item_name)
            content = itemView.findViewById(R.id.star_content)
            imageView = itemView.findViewById(R.id.iv_star)
        }
    }
}