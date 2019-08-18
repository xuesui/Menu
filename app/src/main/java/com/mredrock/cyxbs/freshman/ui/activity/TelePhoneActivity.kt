package com.mredrock.cyxbs.freshman.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewModel.TelephoneActivityViewModel

class TelePhoneActivity : BaseViewModelActivity<TelephoneActivityViewModel>() {
    override val viewModelClass: Class<TelephoneActivityViewModel>
        get() = TelephoneActivityViewModel::class.java
    override val isFragmentActivity: Boolean
        get() = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_tele_phone)
        viewModel.visibleState(this)
        viewModel.doToEdit(this)
        viewModel.sendDefine(this)
        viewModel.writeDefine(this)
    }
}
