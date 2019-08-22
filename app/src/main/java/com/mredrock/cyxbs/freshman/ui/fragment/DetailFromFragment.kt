package com.mredrock.cyxbs.freshman.ui.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mredrock.cyxbs.common.ui.BaseViewModelFragment

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewModel.DetailFromViewModel

class DetailFromFragment : BaseViewModelFragment<DetailFromViewModel>() {
    override val viewModelClass: Class<DetailFromViewModel>
        get() = DetailFromViewModel::class.java

    companion object {
        fun newInstance() = DetailFromFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.app_detail_from_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailFromViewModel::class.java)
        val mId=activity!!.intent.extras.getInt("id")
        viewModel.initview(this,mId)
    }

}
