package com.mredrock.cyxbs.freshman.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
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

class TypeRecyclerAdapter(private val title: ArrayList<String>,
                          private val classId:ArrayList<Int>,
                          private val context: Context
) :
    RecyclerView.Adapter<TypeRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TypeRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.app_type_recycler_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TypeRecyclerAdapter.ViewHolder, position: Int) {
        holder.title.setText(title[position])
        holder.frameLayout.setOnClickListener {
            val intent=Intent(context,MoreRecommandActivity::class.java)
            val bundle=Bundle()
            bundle.putInt("classId",classId[position])
            bundle.putString("title","分类食谱")
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return title.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var title: TextView
        internal var frameLayout:FrameLayout

        init {
            title = itemView.findViewById<View>(R.id.tv_type_item) as TextView
            frameLayout=itemView.findViewById<View>(R.id.fl_type_item) as FrameLayout
        }
    }
}
