package com.mredrock.cyxbs.freshman.utils

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.mredrock.cyxbs.common.utils.extensions.setImageFromUrl
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.activity.TypeActivity
import com.mredrock.cyxbs.freshman.utils.MainRecyclerAdapter.ViewHolder
import de.hdodenhof.circleimageview.CircleImageView

class MainRecyclerAdapter(
    private val pictures: ArrayList<Int>, private val titles: ArrayList<String>,
    private val context: Context
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.app_main_recycler_adpter,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pictures.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.setText(titles.get(position))
        holder.image.setImageResource(pictures.get(position))
        holder.image.setOnClickListener {
            val intent=Intent(context,TypeActivity::class.java)
            val bundle=Bundle()
            bundle.putInt("position",position)
            bundle.putString("title",titles.get(position))
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }


    inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        internal var title:TextView
        internal var image:CircleImageView

        init {
            title=itemView.findViewById<View>(R.id.tv_main_recycler_item) as TextView
            image=itemView.findViewById<View>(R.id.circleimage_main_recycler_item) as CircleImageView
        }

    }

}