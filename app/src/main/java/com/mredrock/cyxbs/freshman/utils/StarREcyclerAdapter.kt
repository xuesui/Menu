package com.mredrock.cyxbs.freshman.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.activity.DetailActivity

import java.util.ArrayList

class StarREcyclerAdapter(
    private val images: List<String>,
    private val names: List<String>,
    private val contents: List<String>,
    private val ids:List<Int>,
    private val context: Context
) : RecyclerView.Adapter<StarREcyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.app_star_recyler_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = names[position]
        holder.content.text = contents[position]
        Glide.with(context).load(images[position]).into(holder.imageView)
        holder.content.setOnClickListener {
            val intent=Intent(context,DetailActivity::class.java)
            val bundle=Bundle()
            bundle.putInt("id",ids.get(position))
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
        holder.imageView.setOnClickListener {
            val intent=Intent(context,DetailActivity::class.java)
            val bundle=Bundle()
            bundle.putInt("id",ids.get(position))
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return images.size
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
