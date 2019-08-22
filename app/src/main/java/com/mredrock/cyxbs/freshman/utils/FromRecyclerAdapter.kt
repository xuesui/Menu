package com.mredrock.cyxbs.freshman.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.mredrock.cyxbs.freshman.R

import java.util.ArrayList

class FromRecyclerAdapter(
    private val name: ArrayList<String>,
    private val weight: ArrayList<String>
) : RecyclerView.Adapter<FromRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.app_detail_from_recycler_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = name[position]
        holder.weight.text = weight[position]
    }

    override fun getItemCount(): Int {
        return name.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var name: TextView
        internal var weight: TextView

        init {
            name = itemView.findViewById<View>(R.id.tv_detail_from_name) as TextView
            weight = itemView.findViewById<View>(R.id.tv_detail_from_weight) as TextView
        }
    }
}
