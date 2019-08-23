package com.mredrock.cyxbs.freshman.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.activity.MoreRecommandActivity
import java.util.ArrayList

class GrassRecyclerAdapter(
    private val title: ArrayList<String>,
    private val food: ArrayList<String>,
    private val imagepic:ArrayList<Int>,
    private val context :Context
) : RecyclerView.Adapter<GrassRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GrassRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.app_grass_recycler_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: GrassRecyclerAdapter.ViewHolder, position: Int) {
        holder.title.setText(title[position])
        holder.image.setImageDrawable(context.resources.getDrawable(imagepic[position],null))
        holder.frame.setOnClickListener {
            val intent=Intent(context,MoreRecommandActivity::class.java)
            val bundle=Bundle()
            bundle.putString("title",title[position])
            bundle.putString("food",food[position])
            bundle.putInt("imagepic",imagepic[position])
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return title.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var title: TextView
        internal var image:ImageView
        internal var frame:FrameLayout

        init {
            title = itemView.findViewById<View>(R.id.tv_grass_item) as TextView
            image = itemView.findViewById<View>(R.id.iv_grass_item) as ImageView
            frame=itemView.findViewById<View>(R.id.fl_grass_item) as FrameLayout
        }
    }
}
