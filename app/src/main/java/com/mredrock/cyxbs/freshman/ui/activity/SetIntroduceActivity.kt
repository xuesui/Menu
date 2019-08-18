package com.mredrock.cyxbs.freshman.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewModel.SetIntroduceActivityViewModel
import com.mredrock.cyxbs.freshman.viewModel.SettingActivityViewModel

class SetIntroduceActivity : BaseViewModelActivity<SetIntroduceActivityViewModel>() {
    override val viewModelClass: Class<SetIntroduceActivityViewModel>
        get() = SetIntroduceActivityViewModel::class.java
    override val isFragmentActivity: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_set_introduce)
        viewModel.doToEdit(this)
        viewModel.complete(this)
        viewModel.back(this)
    }

    override fun onResume() {
        viewModel.changeIntroduce(this)
        super.onResume()
    }
}
