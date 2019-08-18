package com.mredrock.cyxbs.freshman.viewModel

import android.content.Context
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.ui.activity.SetIntroduceActivity
import com.mredrock.cyxbs.freshman.ui.activity.SettingActivity
import kotlinx.android.synthetic.main.app_activity_set_introduce.*
import kotlinx.android.synthetic.main.app_activity_setname.*
import kotlinx.android.synthetic.main.app_activity_setting.*

class SetIntroduceActivityViewModel :BaseViewModel(){

    fun doToEdit(activity:SetIntroduceActivity){
        activity.et_set_introduce.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString()==""){
                    activity.tv_complete_introduce.visibility=View.INVISIBLE
                }else{
                    activity.tv_complete_introduce.visibility=View.VISIBLE
                }
            }
        })
    }


    fun complete(activity: SetIntroduceActivity){
        activity.tv_complete_introduce.setOnClickListener {
            val editor = activity.getSharedPreferences("introduce", Context.MODE_PRIVATE)
                .edit()
            editor.putString("content",activity.et_set_introduce.text.toString())
            editor.apply()
            activity.finish()
        }
    }

    fun changeIntroduce(activity: SetIntroduceActivity){
        val preference=activity.getSharedPreferences("introduce", Context.MODE_PRIVATE)
        val content=preference.getString("content","")
        activity.et_set_introduce.setText(content)
    }

    fun back(activity: SetIntroduceActivity){
        activity.iv_setting_back_introduce.setOnClickListener {
            activity.finish()
        }
    }
}
