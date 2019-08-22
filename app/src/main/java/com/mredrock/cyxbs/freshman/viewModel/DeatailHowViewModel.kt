package com.mredrock.cyxbs.freshman.viewModel

import androidx.lifecycle.ReportFragment
import androidx.lifecycle.ViewModel;
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.model.DetailModel
import com.mredrock.cyxbs.freshman.ui.fragment.DeatailHowFragment

class DeatailHowViewModel : BaseViewModel() {
    private val model=DetailModel()

    fun initview(fragment: DeatailHowFragment,id:Int){
        model.requestId(fragment,id)
    }
}
