package com.mredrock.cyxbs.freshman.viewModel

import androidx.viewpager.widget.ViewPager
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.model.DetailModel
import com.mredrock.cyxbs.freshman.ui.activity.DetailActivity
import com.mredrock.cyxbs.freshman.ui.fragment.DeatailHowFragment
import com.mredrock.cyxbs.freshman.ui.fragment.DetailContentFragment
import com.mredrock.cyxbs.freshman.ui.fragment.DetailFromFragment
import com.mredrock.cyxbs.freshman.utils.FragmentAdapter
import com.mredrock.cyxbs.freshman.utils.HowPageAdapter
import com.mredrock.cyxbs.freshman.weight.CursorView
import kotlinx.android.synthetic.main.app_activity_detail.*

class DetailActivityViewModel : BaseViewModel() {
    private val title = arrayListOf("做法", "食材", "相关内容")
    val fragments= arrayListOf(DeatailHowFragment.newInstance(),DetailFromFragment.newInstance(),
        DetailContentFragment.newInstance())
    val detailModel=DetailModel()

    fun initViewPager(activity: DetailActivity) {
        val adpter = HowPageAdapter(title,activity.supportFragmentManager,fragments)
        activity.vp_detail.adapter = adpter
        activity.tl_detail.setupWithViewPager(activity.vp_detail)
    }

    fun requestId(activity: DetailActivity, id: Int) {
        detailModel.requestId(activity,id)
    }

}
