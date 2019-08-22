package com.mredrock.cyxbs.freshman.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewModel.SearchActivityViewModel
import kotlinx.android.synthetic.main.app_activity_search.*

class SearchActivity : BaseViewModelActivity<SearchActivityViewModel>() {
    override val viewModelClass: Class<SearchActivityViewModel>
        get() = SearchActivityViewModel::class.java
    override val isFragmentActivity: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_search)

        val content=intent.extras.getString("content")
        viewModel.search(this,content)
        search_back.setOnClickListener {
            finish()
        }
    }
}
