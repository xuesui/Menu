package com.mredrock.cyxbs.freshman.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewModel.TypeActivityViewModel
import kotlinx.android.synthetic.main.app_activity_type.*

class TypeActivity : BaseViewModelActivity<TypeActivityViewModel>() {
    override val viewModelClass: Class<TypeActivityViewModel>
        get() = TypeActivityViewModel::class.java
    override val isFragmentActivity: Boolean
        get() = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_type)
        val position=intent.extras.getInt("position")
        val title=intent.extras.getString("title")
        viewModel.initview(this,position)
        tv_type.setText(title)
        iv_back_type.setOnClickListener {
            finish()
        }
    }
}
