package com.mredrock.cyxbs.freshman.ui.activity

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewModel.SettingActivityViewModel
import de.hdodenhof.circleimageview.CircleImageView

class SettingActivity : BaseViewModelActivity<SettingActivityViewModel>() {

    override val viewModelClass: Class<SettingActivityViewModel>
        get() = SettingActivityViewModel::class.java
    override val isFragmentActivity: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_setting)
        viewModel.back(this)
        viewModel.setname(this)
        viewModel.setIntroduce(this)
    }

    override fun onResume() {
        viewModel.changeName(this)
        super.onResume()
    }


}
