package com.mredrock.cyxbs.freshman.viewModel

import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.model.DetailModel
import com.mredrock.cyxbs.freshman.ui.fragment.DetailFromFragment

class DetailFromViewModel : BaseViewModel() {
    private val model =DetailModel()

    fun initview(fragment: DetailFromFragment,id:Int){
        model.requestId(fragment,id)
    }
}
