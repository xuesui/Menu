package com.mredrock.cyxbs.freshman.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewModel.MoreRecommandActivityViewModel

class MoreRecommandActivity : BaseViewModelActivity<MoreRecommandActivityViewModel>() {
    override val viewModelClass: Class<MoreRecommandActivityViewModel>
        get() = MoreRecommandActivityViewModel::class.java
    override val isFragmentActivity: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_more_recommand)
        val title = intent.extras.getString("title")
        viewModel.initView(this,title)
        viewModel.initRecyclerView(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
