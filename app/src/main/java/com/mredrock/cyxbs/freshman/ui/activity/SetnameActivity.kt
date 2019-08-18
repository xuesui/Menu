package com.mredrock.cyxbs.freshman.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewModel.SetNameActivityViewModel

class SetnameActivity : BaseViewModelActivity<SetNameActivityViewModel>() {
    override val viewModelClass: Class<SetNameActivityViewModel>
        get() = SetNameActivityViewModel::class.java
    override val isFragmentActivity: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_setname)
        viewModel.back(this)
        viewModel.doToEdit(this)
        viewModel.complete(this)
    }
}
