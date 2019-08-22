package com.mredrock.cyxbs.freshman.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.app_activity_login.*
import org.jetbrains.anko.backgroundColor
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewModel.LoginActivityViewModel


class LoginActivity : BaseViewModelActivity<LoginActivityViewModel>(), View.OnClickListener {
    override val viewModelClass: Class<LoginActivityViewModel>
        get() = LoginActivityViewModel::class.java

    override val isFragmentActivity: Boolean
        get() = true

    override fun onClick(view: View) {
        when (view) {
            shawdow_2 -> {
                vp_log_in.currentItem = 1
                shawdow_2.backgroundColor=Color.parseColor("#F5E261")
                shawdow_1.backgroundColor=Color.parseColor("#F3FFFD")
            }

            shawdow_1 -> {
                vp_log_in.currentItem = 0
                shawdow_2.backgroundColor=Color.parseColor("#F3FFFD")
                shawdow_1.backgroundColor=Color.parseColor("#F5E261")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_login)
        shawdow_1.setOnClickListener(this)
        shawdow_2.setOnClickListener(this)
        viewModel.visibleState(this)
        viewModel.initView(this)
    }


    inner class MyPagerChangeListener : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {

        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

        }

        override fun onPageSelected(position: Int) {
            when (position) {
                0 -> {
                    vp_log_in.currentItem = 0
                    shawdow_2.backgroundColor=Color.parseColor("#F5E261")
                    shawdow_1.backgroundColor=Color.parseColor("#F3FFFD")
                }

                1 -> {
                    vp_log_in.currentItem = 1
                    shawdow_2.backgroundColor=Color.parseColor("#F3FFFD")
                    shawdow_1.backgroundColor=Color.parseColor("#F5E261")
                }
            }
        }

    }

}
