package com.mredrock.cyxbs.freshman.ui.fragment

import android.content.Intent
import android.os.Build
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.mredrock.cyxbs.common.ui.BaseViewModelFragment

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.utils.FragmentAdapter
import com.mredrock.cyxbs.freshman.viewModel.CommulityViewModel
import com.mredrock.cyxbs.freshman.weight.CursorView
import kotlinx.android.synthetic.main.app_activity_detail.*
import java.time.LocalDate

class CommulityFragment : BaseViewModelFragment<CommulityViewModel>() {
    override val viewModelClass: Class<CommulityViewModel>
        get() = CommulityViewModel::class.java
    val data= if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
     LocalDate.now()
 } else {
     TODO("VERSION.SDK_INT < O")
 }

    private val list = arrayListOf(
        DeatailHowFragment(), DetailFromFragment(), DetailContentFragment())

    companion object {
        fun newInstance() = CommulityFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.app_commulity_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CommulityViewModel::class.java)
        viewModel.add(this)
        viewModel.initView(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (viewModel != null) {
            viewModel.fromphotoalbum(this, requestCode, resultCode, data!!)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.initView(this)
    }
}
