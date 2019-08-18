package com.mredrock.cyxbs.freshman.viewModel

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import cn.leancloud.AVUser
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.ui.activity.LoginActivity
import com.mredrock.cyxbs.freshman.ui.activity.MainActivity
import com.mredrock.cyxbs.freshman.ui.activity.TelePhoneActivity
import com.mredrock.cyxbs.freshman.ui.activity.TelePhoneUPActivity
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.app_activity_tele_phone.*
import kotlinx.android.synthetic.main.app_activity_tele_phone_up.*
import kotlinx.android.synthetic.main.app_activity_tele_phone_up.tele_cv_logup

class TelephoneActivityViewModel :BaseViewModel(){
    private var isClick = false

    //状态栏沉浸式
    fun visibleState(activity: TelePhoneActivity){
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = activity.getWindow().getDecorView()
            val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN ;  View.SYSTEM_UI_FLAG_LAYOUT_STABLE

            decorView.setSystemUiVisibility(option)
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT)
        }
        val actionBar = activity.getSupportActionBar()
        actionBar?.hide()
    }

    //edit的控制
    fun doToEdit(activity: TelePhoneActivity) {
        activity.et_tele_login.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString() == "") {
                    activity.tele_cv_login.visibility = View.INVISIBLE
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString() == "") {
                    activity.tele_cv_login.visibility = View.INVISIBLE
                } else {
                    activity.tele_cv_login.visibility = View.VISIBLE
                }
            }
        })
    }

//发送验证码
    fun sendDefine(activity: TelePhoneActivity) {
        activity.sl_send_define_login.setOnClickListener {
            if (isClick == false) {
                activity.tv_send_define_login.text="已发送"
                isClick = true
                if (activity.et_tele_login.text.toString() != "") {
                    val avUser = AVUser()
                    avUser.mobilePhoneNumber = "+86${activity.et_tele_login.text}"
                    AVUser.requestLoginSmsCodeInBackground("+86${activity.et_tele_login.text}")
                        .blockingSubscribe()
                } else {
                    Toast.makeText(activity, "手机号不能为空", Toast.LENGTH_SHORT).show()
                    isClick = false
                    activity.tv_send_define_login.text="发送验证码"
                }
            }
        }
    }


    //登录
    fun writeDefine(activity: TelePhoneActivity) {
        activity.asv_tele_login.setOnClickListener {
            if (activity.et_define_login.text.toString() != "") {
                AVUser.signUpOrLoginByMobilePhoneInBackground(
                    "+86${activity.et_tele_login.text}",
                    activity.et_define_login.text.toString()
                )
                    .subscribe(object : Observer<AVUser> {
                        override fun onComplete() {

                        }

                        override fun onSubscribe(d: Disposable) {

                        }

                        override fun onNext(t: AVUser) {
                            activity.tv_send_define_login.text="发送验证码"
                            val intent = Intent(activity, MainActivity::class.java)
                            activity.startActivity(intent)
                        }

                        @SuppressLint("ShowToast")
                        override fun onError(e: Throwable) {
                            Toast.makeText(activity, "验证码或手机号输入错误！", Toast.LENGTH_SHORT)
                        }

                    })
            } else {
                Toast.makeText(activity, "输入验证码不能为空！", Toast.LENGTH_SHORT).show()
                isClick = false
                activity.tv_send_define_login.text="发送验证码"
            }
        }
    }
}