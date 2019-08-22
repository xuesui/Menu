package com.mredrock.cyxbs.freshman.viewModel

import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.litepal.Past
import com.mredrock.cyxbs.freshman.model.StarModel
import com.mredrock.cyxbs.freshman.ui.activity.PastActivity
import com.mredrock.cyxbs.freshman.utils.StarREcyclerAdapter
import kotlinx.android.synthetic.main.app_activity_past.*
import org.litepal.crud.DataSupport

class PastActivityViewModel :BaseViewModel(){
    private val model=StarModel()

    fun delete(activity:PastActivity){

        activity.tv_past_delete.setOnClickListener {
            val pasts=DataSupport.findAll(Past::class.java)
            if (pasts.size!=0){
                DataSupport.deleteAll(Past::class.java)
                val images=ArrayList<String>()
                val contents=ArrayList<String>()
                val names=ArrayList<String>()
                val ids=ArrayList<Int>()
                val adapter =StarREcyclerAdapter(images,names,contents,ids,activity)
                adapter.notifyDataSetChanged()
                val layoutManager= LinearLayoutManager(activity)
                activity.past_recycler.layoutManager=layoutManager
                activity.past_recycler.adapter=adapter
                Toast.makeText(activity,"清空成功",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(activity,"没有足迹可以删除！",Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun requestId(activity: PastActivity,id:ArrayList<Int>){
        model.requestid(activity,id)
    }
}

