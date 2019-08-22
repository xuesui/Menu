package com.mredrock.cyxbs.freshman.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.litepal.Past
import com.mredrock.cyxbs.freshman.viewModel.PastActivityViewModel
import kotlinx.android.synthetic.main.app_activity_past.*
import org.litepal.crud.DataSupport

class PastActivity : BaseViewModelActivity<PastActivityViewModel>() {
    val ids=ArrayList<Int>()
    override val viewModelClass: Class<PastActivityViewModel>
        get() = PastActivityViewModel::class.java
    override val isFragmentActivity: Boolean
        get() =false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_past)
        past_back.setOnClickListener {
            finish()
        }
        val pasts=DataSupport.findAll(Past::class.java)
        for (i in 0 until pasts.size) {
            ids.add(pasts[i].past)
        }
        Log.d("YYY","aa"+ids.size)
        viewModel.requestId(this,ids)
        viewModel.delete(this)
    }
}
