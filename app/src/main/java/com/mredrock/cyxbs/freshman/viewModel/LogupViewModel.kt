package com.mredrock.cyxbs.freshman.viewModel

import android.content.Intent
import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import cn.leancloud.AVUser
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.ui.fragment.LogupFragment
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.app_activity_login.*
import kotlinx.android.synthetic.main.app_logup_fragment.*
import org.jetbrains.anko.backgroundColor

class LogupViewModel : BaseViewModel() {

    fun doToEdit(logupFragment: LogupFragment){
        logupFragment.et_write_account.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString()==""){
                    logupFragment.account_cv_logup.visibility= View.INVISIBLE
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString()==""){
                    logupFragment.account_cv_logup.visibility= View.INVISIBLE
                }else{
                    logupFragment.account_cv_logup.visibility= View.VISIBLE
                }
            }
        })


        logupFragment.et_write_code.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString()==""){
                    logupFragment.code_cv_logup.visibility= View.INVISIBLE
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString()==""){
                    logupFragment.code_cv_logup.visibility= View.INVISIBLE
                }else{
                    logupFragment.code_cv_logup.visibility= View.VISIBLE
                }
            }
        })
    }

    fun clickListener(logupFragment: LogupFragment){
        logupFragment.asv_loghup.setOnClickListener {
            val user=AVUser()
            user.username=logupFragment.et_write_account.text.toString()
            user.password=logupFragment.et_write_code.text.toString()
            user.signUpInBackground().subscribe(object : io.reactivex.Observer<AVUser> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onComplete() {

                }

                override fun onNext(t: AVUser) {
                    LogUtils.d("用户id:",user.objectId)
                    logupFragment.activity!!.vp_log_in.currentItem=1
                    logupFragment.activity!!.shawdow_2.backgroundColor= Color.parseColor("#F3FFFD")
                    logupFragment.activity!!.shawdow_1.backgroundColor= Color.parseColor("#F5E261")
                }

                override fun onError(e: Throwable) {
                    Toast.makeText(logupFragment.context,"注册失败,该用户名已存在！",Toast.LENGTH_SHORT).show()
                }

            })
        }

    }
}
