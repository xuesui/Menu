package com.mredrock.cyxbs.freshman.ui.activity

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.fragment.CommulityFragment
import com.mredrock.cyxbs.freshman.ui.fragment.MainFragment
import com.mredrock.cyxbs.freshman.ui.fragment.SelfFragment
import com.mredrock.cyxbs.freshman.viewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.app_activity_main.*

class MainActivity : BaseViewModelActivity<MainActivityViewModel>(), BottomNavigationBar.OnTabSelectedListener{
    override fun onTabReselected(position: Int) {

    }

    override fun onTabUnselected(position: Int) {

    }

    override fun onTabSelected(position: Int) {
        val fm=supportFragmentManager
        val trancision=fm.beginTransaction()
        when(position){
            0 -> trancision.replace(R.id.scroll_main_fragment,MainFragment.newInstance())
            1 -> trancision.replace(R.id.scroll_main_fragment,CommulityFragment.newInstance())
            2 -> trancision.replace(R.id.scroll_main_fragment,SelfFragment.newInstance())
        }
        trancision.commit()
    }

    override val viewModelClass: Class<MainActivityViewModel>
        get() = MainActivityViewModel::class.java
    override val isFragmentActivity: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_main)
        viewModel.doToBottomNavigation(this)
    }

}
