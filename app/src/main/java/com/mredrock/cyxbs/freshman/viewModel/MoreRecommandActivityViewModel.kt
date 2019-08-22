package com.mredrock.cyxbs.freshman.viewModel

import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.model.MoreModel
import com.mredrock.cyxbs.freshman.ui.activity.MoreRecommandActivity
import kotlinx.android.synthetic.main.app_activity_more_recommand.*

class MoreRecommandActivityViewModel : BaseViewModel() {
    private val model = MoreModel()

    fun initView(activity: MoreRecommandActivity,title:String) {

        activity.setSupportActionBar(activity.more_toolbar)
        val actionbar = activity.supportActionBar
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true)
        }
        activity.more_coll.title = title
    }

    fun initRecyclerView(activity: MoreRecommandActivity) {
        model.moreRecommand(activity)
    }
}