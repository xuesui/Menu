package com.mredrock.cyxbs.freshman.viewModel

import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.litepal.Star
import com.mredrock.cyxbs.freshman.model.StarModel
import com.mredrock.cyxbs.freshman.ui.activity.SearchActivity
import com.mredrock.cyxbs.freshman.ui.activity.StarActivity

class StarActivityViewModel :BaseViewModel(){
    private val model=StarModel()

    fun requestid(activity: StarActivity,id:ArrayList<Int>){
        model.requestid(activity,id)
    }

    fun store(id:Int){
        val star= Star()
        star.setWhich(id)
        star.save()
    }
}