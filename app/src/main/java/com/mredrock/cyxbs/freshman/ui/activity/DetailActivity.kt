package com.mredrock.cyxbs.freshman.ui.activity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TableLayout
import com.google.android.material.tabs.TabLayout
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.litepal.Past
import com.mredrock.cyxbs.freshman.viewModel.DetailActivityViewModel
import kotlinx.android.synthetic.main.app_activity_detail.*
import kotlinx.android.synthetic.main.app_activity_main.*

class DetailActivity : BaseViewModelActivity<DetailActivityViewModel>(){

    override val viewModelClass: Class<DetailActivityViewModel>
        get() = DetailActivityViewModel::class.java
    override val isFragmentActivity: Boolean
        get() = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_detail)
        setSupportActionBar(detail_toolbar)
        detail_toolbar.setNavigationIcon(R.drawable.detail_back)
        detail_toolbar.setNavigationOnClickListener {
            finish()
        }
        detail_collapsing_toolbar.setCollapsedTitleTextColor(Color.parseColor("#404040"))
        viewModel.initViewPager(this)
        val mId=intent.extras?.getInt("id")
        if (mId!=null&&mId!=0){
            val past=Past()
            past.past=mId
            past.save()
            viewModel.requestId(this,mId)
            float_detail.setOnClickListener {
                val intent=Intent(this,StarActivity::class.java)
                val bundle=Bundle()
                bundle.putInt("id",mId)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }

    }

}
