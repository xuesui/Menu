package com.mredrock.cyxbs.freshman.viewModel

import android.graphics.Color
import android.os.Build
import android.view.View
import androidx.fragment.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.activity.MainActivity
import com.mredrock.cyxbs.freshman.ui.fragment.MainFragment
import kotlinx.android.synthetic.main.app_activity_main.*

class MainActivityViewModel : BaseViewModel() {

    private var lastSelectedPosition = 0


    fun doToBottomNavigation(activity: MainActivity) {
        activity.bnb_main.setTabSelectedListener(activity)
            .setMode(BottomNavigationBar.MODE_FIXED)
            .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
            .setActiveColor("#FFFFFF")
            .setInActiveColor("#5D5D5D")
            .setBarBackgroundColor("#FF8F5D")

        activity.bnb_main
            .addItem(BottomNavigationItem(R.drawable.main, "首页"))
            .addItem(BottomNavigationItem(R.drawable.commulity, "社区"))
            .addItem(BottomNavigationItem(R.drawable.self, "我的"))
            .setFirstSelectedPosition(lastSelectedPosition)
            .initialise()

        val fm = activity.supportFragmentManager;
        val transaction = fm.beginTransaction();
        val mMainFragment = MainFragment.newInstance()
        transaction.replace(R.id.scroll_main_fragment , mMainFragment)
        transaction.commit()
    }


}