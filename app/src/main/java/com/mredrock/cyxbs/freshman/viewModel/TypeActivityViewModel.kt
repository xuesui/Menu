package com.mredrock.cyxbs.freshman.viewModel

import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.model.TypeModel
import com.mredrock.cyxbs.freshman.ui.activity.TypeActivity

class TypeActivityViewModel :BaseViewModel(){
    private val model=TypeModel()

    fun initview(activity:TypeActivity,position:Int){
        model.requestClassId(activity,position)
    }
}