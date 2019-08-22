package com.mredrock.cyxbs.freshman.ui.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.utils.FragmentAdapter
import com.mredrock.cyxbs.freshman.viewModel.CommulityViewModel
import com.mredrock.cyxbs.freshman.weight.CursorView
import kotlinx.android.synthetic.main.app_activity_detail.*

class CommulityFragment : Fragment() {

    private val list = arrayListOf(
        DeatailHowFragment(), DetailFromFragment(), DetailContentFragment())

    companion object {
        fun newInstance() = CommulityFragment()
    }

    private lateinit var viewModel: CommulityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.app_commulity_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CommulityViewModel::class.java)
        // TODO: Use the ViewModel
        val cursorView = CursorView(activity!!)
        val adpter = FragmentAdapter(activity!!.supportFragmentManager, list)
    }

}
