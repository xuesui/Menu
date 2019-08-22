package com.mredrock.cyxbs.freshman.viewModel

import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.litepal.Star
import com.mredrock.cyxbs.freshman.model.SearchModel
import com.mredrock.cyxbs.freshman.ui.activity.SearchActivity

class SearchActivityViewModel :BaseViewModel(){
    private val model=SearchModel()

    fun search(activity:SearchActivity,content:String){
        model.search(activity,content)
    }



}