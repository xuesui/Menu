package com.mredrock.cyxbs.freshman.viewModel

import android.graphics.Color
import android.os.Build
import android.view.View
import androidx.fragment.app.Fragment
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.ui.activity.LoginActivity
import com.mredrock.cyxbs.freshman.utils.FragmentAdapter
import com.mredrock.cyxbs.freshman.ui.fragment.LoginFragment
import com.mredrock.cyxbs.freshman.ui.fragment.LogupFragment
import kotlinx.android.synthetic.main.app_activity_login.*
import org.jetbrains.anko.backgroundColor

class LoginActivityViewModel : BaseViewModel(){
    private val fragments = ArrayList<Fragment>()

    //状态栏沉浸式
    fun visibleState(activity: LoginActivity){
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = activity.getWindow().getDecorView()
            val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN ;  View.SYSTEM_UI_FLAG_LAYOUT_STABLE

            decorView.setSystemUiVisibility(option)
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT)
        }
        val actionBar = activity.getSupportActionBar()
        actionBar?.hide()
    }

//初始化页面
    fun initView(activity: LoginActivity) {
        activity.vp_log_in.addOnPageChangeListener(activity.MyPagerChangeListener())
        fragments.add(LogupFragment.newInstance())
        fragments.add(LoginFragment.newInstance())
        val adapter = FragmentAdapter(activity.supportFragmentManager, fragments)
        activity.vp_log_in.adapter = adapter
        activity.vp_log_in.currentItem = 1
        activity.shawdow_1.backgroundColor=Color.parseColor("#F5E261")
    }


}