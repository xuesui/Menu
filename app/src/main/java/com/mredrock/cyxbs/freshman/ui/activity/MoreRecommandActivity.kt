package com.mredrock.cyxbs.freshman.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewModel.MoreRecommandActivityViewModel
import kotlinx.android.synthetic.main.app_activity_more_recommand.*

class MoreRecommandActivity : BaseViewModelActivity<MoreRecommandActivityViewModel>() {
    override val viewModelClass: Class<MoreRecommandActivityViewModel>
        get() = MoreRecommandActivityViewModel::class.java
    override val isFragmentActivity: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_more_recommand)
        val title = intent.extras.getString("title")
        Log.d("RRR","aa"+title)
        viewModel.initView(this,title)
        if (title=="今日新品"){
            viewModel.initRecyclerView(this)
            iv_more_recommand.setImageDrawable(resources.getDrawable(R.drawable.cake,null))
        }else if (title=="分类食谱"){
            val classId=intent.extras.getInt("classId")
            viewModel.initType(this,classId)
            iv_more_recommand.setImageDrawable(resources.getDrawable(R.drawable.type,null))
        } else{
            val food=intent.extras.getString("food")
            val image=intent.extras.getInt("imagepic")
            iv_more_recommand.setImageDrawable(resources.getDrawable(image,null))
            viewModel.initMore(this,food)
        }


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
