package com.mredrock.cyxbs.freshman.viewModel

import androidx.lifecycle.ViewModel;
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.model.DetailModel
import com.mredrock.cyxbs.freshman.ui.fragment.DetailContentFragment

class DetailContentViewModel : BaseViewModel() {
    private val model=DetailModel()

    fun initview(fragment: DetailContentFragment,id:Int){
        model.requestId(fragment,id)
    }
}
