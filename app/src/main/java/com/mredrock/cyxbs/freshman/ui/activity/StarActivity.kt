package com.mredrock.cyxbs.freshman.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.litepal.Star
import com.mredrock.cyxbs.freshman.viewModel.StarActivityViewModel
import kotlinx.android.synthetic.main.app_activity_star.*
import org.litepal.LitePal
import org.litepal.crud.DataSupport

class StarActivity : BaseViewModelActivity<StarActivityViewModel>() {
    private val ids = ArrayList<Int>()
    private val iId=ArrayList<Int>()
    override val viewModelClass: Class<StarActivityViewModel>
        get() = StarActivityViewModel::class.java
    override val isFragmentActivity: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_star)
        val mid = intent.extras?.getInt("id")
        if (mid!=null&&mid!=0){
            viewModel.store(mid)
        }
        val stars = DataSupport.findAll(Star::class.java)
        for (i in 0 until stars.size) {
            ids.add(stars[i].which)
            iId.add(stars[i].id)
        }
        viewModel.requestid(this, ids,iId)
        star_back.setOnClickListener {
            finish()
        }
    }
}
