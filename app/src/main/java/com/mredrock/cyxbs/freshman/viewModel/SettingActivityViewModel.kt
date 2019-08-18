package com.mredrock.cyxbs.freshman.viewModel

import android.content.Context
import android.content.Intent
import android.util.Log
import cn.leancloud.AVObject
import cn.leancloud.AVQuery
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.ui.activity.SetIntroduceActivity
import com.mredrock.cyxbs.freshman.ui.activity.SetnameActivity
import com.mredrock.cyxbs.freshman.ui.activity.SettingActivity
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.app_activity_setting.*
import kotlinx.android.synthetic.main.app_self_fragment.*


class SettingActivityViewModel : BaseViewModel() {

    fun back(activity: SettingActivity) {
        activity.rl_back.setOnClickListener {
            activity.finish()
        }
    }

    fun setname(activity: SettingActivity){
        activity.rl_setting_name.setOnClickListener {
            val intent=Intent(activity,SetnameActivity::class.java)
            activity.startActivity(intent)
        }
    }

    fun changeName(activity: SettingActivity){
        val preference=activity.getSharedPreferences("nickname", Context.MODE_PRIVATE)
        val name=preference.getString("name","")
        activity.tv_nick_names.setText(name)
    }

    fun setIntroduce(activity: SettingActivity){
        activity.rl_introduce.setOnClickListener {
            val intent=Intent(activity,SetIntroduceActivity::class.java)
            activity.startActivity(intent)
        }
    }
}