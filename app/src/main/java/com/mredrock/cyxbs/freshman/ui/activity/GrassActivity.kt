package com.mredrock.cyxbs.freshman.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewModel.GrassActivityViewModel
import kotlinx.android.synthetic.main.app_activity_grass.*

class GrassActivity : BaseViewModelActivity<GrassActivityViewModel>() {
    override val viewModelClass: Class<GrassActivityViewModel>
        get() = GrassActivityViewModel::class.java
    override val isFragmentActivity: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_grass)
        viewModel.initView(this)
        iv_back_grass.setOnClickListener {
            finish()
        }
    }
}
