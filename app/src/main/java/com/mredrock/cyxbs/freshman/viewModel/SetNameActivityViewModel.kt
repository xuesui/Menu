package com.mredrock.cyxbs.freshman.viewModel

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.ui.activity.SetnameActivity
import kotlinx.android.synthetic.main.app_activity_setname.*
import kotlinx.android.synthetic.main.app_activity_setname.iv_setting_back
import kotlinx.android.synthetic.main.app_activity_setting.*
import cn.leancloud.AVObject
import com.mredrock.cyxbs.freshman.ui.activity.SettingActivity


class SetNameActivityViewModel : BaseViewModel(){

    fun back(activity:SetnameActivity){
        activity.iv_setting_back.setOnClickListener {
            activity.finish()
        }
    }

    fun doToEdit(activity: SetnameActivity){
        activity.et_set_nickname.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString()!=""){
                    activity.tv_complete.visibility=View.VISIBLE
                }else{
                    activity.tv_complete.visibility=View.INVISIBLE
                }
            }

        })
    }

    fun complete(activity: SetnameActivity){
        activity.tv_complete.setOnClickListener {
            val editor = activity.getSharedPreferences("nickname", Context.MODE_PRIVATE)
                .edit()
            editor.putString("name",activity.et_set_nickname.text.toString())
            editor.apply()
            activity.finish()
        }
    }
}