package com.mredrock.cyxbs.freshman.ui.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mredrock.cyxbs.common.ui.BaseViewModelFragment

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewModel.DeatailHowViewModel
import kotlinx.android.synthetic.main.appdeatail_how_fragment.*

class DeatailHowFragment : BaseViewModelFragment<DeatailHowViewModel>(){
    override val viewModelClass: Class<DeatailHowViewModel>
        get() = DeatailHowViewModel::class.java

    companion object {
        fun newInstance() = DeatailHowFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.appdeatail_how_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DeatailHowViewModel::class.java)
        val mId=activity!!.intent.extras.getInt("id")
        Log.d("RRR","ll"+mId)
        viewModel.initview(this,mId)
    }
}
