package com.mredrock.cyxbs.freshman.utils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.litepal.Share
import org.jetbrains.anko.find
import org.litepal.crud.DataSupport
import java.time.LocalDate
import java.time.LocalDateTime

class CommulityRecyclerAdapter(private val context: Context,
                               private val images:ArrayList<String>,
                               private val dates:ArrayList<LocalDateTime>,
                               private val contents:ArrayList<String>)
    : RecyclerView.Adapter<CommulityRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.app_commulity_recycler_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contents.size
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val preference2 = context.getSharedPreferences("selfimage", Context.MODE_PRIVATE)
        val path = preference2.getString("path", "")
        val bitmap = BitmapFactory.decodeFile(path)
        holder.path.setImageBitmap(bitmap)

        val preference1 = context.getSharedPreferences("nickname", Context.MODE_PRIVATE)
        val name = preference1.getString("name", "")
        holder.name.setText(name)

        holder.content.setText(contents[position])

        val bitmap2 = BitmapFactory.decodeFile(images[position])
        holder.image.setImageBitmap(bitmap2)


        holder.date.setText("${dates.get(position).year}年${dates.get(position).monthValue}月${dates.get(position).dayOfMonth}日  ${dates.get(position).hour}:${dates.get(position).minute}")

        holder.linearLayout.setOnLongClickListener {
            images.removeAt(position)
            contents.removeAt(position)
            this.notifyItemRemoved(position)
            this.notifyItemRangeChanged(0,images.size-position)
            DataSupport.delete(Share::class.java, (position+1).toLong())
            return@setOnLongClickListener true
        }
    }

    inner class ViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){
        internal var path:ImageView
        internal var name: TextView
        internal var content: TextView
        internal var image: ImageView
        internal var date:TextView
        internal var linearLayout:LinearLayout

        init {
            name = itemView.findViewById<View>(R.id.tv_commulity_item_name) as TextView
            content = itemView.findViewById<View>(R.id.tv_commulity_item_content) as TextView
            image = itemView.findViewById<View>(R.id.iv_commulity_item_content) as ImageView
            path=itemView.findViewById<View>(R.id.iv_commulity_item_head) as ImageView
            linearLayout=itemView.findViewById<View>(R.id.ll_commulity_item) as LinearLayout
            date=itemView.findViewById<View>(R.id.tv_commulity_item_date) as TextView
        }

    }


}