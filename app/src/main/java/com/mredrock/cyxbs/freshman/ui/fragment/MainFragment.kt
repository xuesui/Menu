package com.mredrock.cyxbs.freshman.ui.fragment

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.mredrock.cyxbs.common.ui.BaseViewModelFragment
import com.mredrock.cyxbs.common.utils.extensions.setImageFromUrl

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewModel.MainViewModel
import kotlinx.android.synthetic.main.app_main_fragment.*
import java.util.*

class MainFragment : BaseViewModelFragment<MainViewModel>() {
    val random= Random()

    override val viewModelClass: Class<MainViewModel>
        get() = MainViewModel::class.java

    companion object {
        fun newInstance() = MainFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.app_main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.initBanner(this)
        viewModel.initRecyclerView(this)

        val id1=random.nextInt(56383)
        viewModel.initDaily(this,id1,1)
        viewModel.todetail(this,id1,1)
        val id2=random.nextInt(56383)
        viewModel.initDaily(this,id2,2)
        viewModel.todetail(this,id2,2)
        viewModel.refresh(this)
        viewModel.search(this)
        viewModel.toMoreRecommand(this)
        viewModel.toGrass(this)
    }

}
