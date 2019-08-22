package com.mredrock.cyxbs.freshman.viewModel

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import cn.leancloud.AVObject
import cn.leancloud.AVUser
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.common.utils.extensions.sharedPreferences
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.ui.activity.MainActivity
import com.mredrock.cyxbs.freshman.ui.activity.TelePhoneActivity
import com.mredrock.cyxbs.freshman.ui.fragment.LoginFragment
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.app_activity_login.*
import kotlinx.android.synthetic.main.app_login_fragment.*
import kotlinx.android.synthetic.main.app_login_fragment.tv_login_to_logup
import org.jetbrains.anko.backgroundColor

class LoginViewModel : BaseViewModel() {

    fun doToEdit(loginFragment: LoginFragment) {
        loginFragment.activity!!.et_account.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString() == "") {
                    loginFragment.activity!!.account_cv.visibility = View.INVISIBLE
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString() == "") {
                    loginFragment.activity!!.account_cv.visibility = View.INVISIBLE
                } else {
                    loginFragment.activity!!.account_cv.visibility = View.VISIBLE
                }
            }
        })


        loginFragment.activity!!.et_code.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString() == "") {
                    loginFragment.activity!!.code_cv.visibility = View.INVISIBLE
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString() == "") {
                    loginFragment.activity!!.code_cv.visibility = View.INVISIBLE
                } else {
                    loginFragment.activity!!.code_cv.visibility = View.VISIBLE
                }
            }
        })
    }


    fun OnClickLisner(loginFragment: LoginFragment) {
        loginFragment.tv_login_to_logup.setOnClickListener {
            loginFragment.activity!!.vp_log_in.currentItem = 0
            loginFragment.activity!!.shawdow_1.backgroundColor = Color.parseColor("#F3FFFD")
            loginFragment.activity!!.shawdow_2.backgroundColor = Color.parseColor("#F5E261")
        }

        loginFragment.tv_login_telephone.setOnClickListener {
            val intent = Intent(loginFragment.context, TelePhoneActivity::class.java)
            loginFragment.startActivity(intent)
        }

        loginFragment.asv_loghin.setOnClickListener {
            AVUser.logIn(loginFragment.et_account.text.toString(), loginFragment.et_code.text.toString())
                .subscribe(object : Observer<AVUser> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(t: AVUser) {
                        createUserObjectid(loginFragment, t)
                        val intent = Intent(loginFragment.context, MainActivity::class.java)
                        loginFragment.startActivity(intent)

                    }

                    override fun onError(e: Throwable) {
                        Toast.makeText(loginFragment.context, "用户名或密码输入错误", Toast.LENGTH_SHORT).show()
                    }

                })
        }
    }

    private fun createUserObjectid(loginFragment: LoginFragment, t: AVUser) {
        val user = AVObject("InUser")
        user.put("name", t.username)
        Log.d("testtt:","aa"+t.username)
        user.saveInBackground().subscribe(object : Observer<AVObject> {
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {

            }

            @SuppressLint("CommitPrefEdits")
            override fun onNext(t: AVObject) {
                val editor = loginFragment.activity!!.getSharedPreferences("objectid", Context.MODE_PRIVATE)
                    .edit()
                editor.putString("userid", t.objectId)
                editor.apply()
            }

            override fun onError(e: Throwable) {

            }
        })
    }
}
