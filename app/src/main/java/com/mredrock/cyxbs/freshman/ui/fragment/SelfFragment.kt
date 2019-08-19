package com.mredrock.cyxbs.freshman.ui.fragment

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mredrock.cyxbs.common.ui.BaseViewModelFragment

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewModel.SelfViewModel
import kotlinx.android.synthetic.main.app_self_fragment.*

class SelfFragment : BaseViewModelFragment<SelfViewModel>() {
    override val viewModelClass: Class<SelfViewModel>
        get() = SelfViewModel::class.java

    companion object {
        fun newInstance() = SelfFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.app_self_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SelfViewModel::class.java)
        viewModel.toSettings(this)
        viewModel.quitLogin(this)
        viewModel.changeImage(this)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (viewModel != null) {
            viewModel.fromphotoalbum(this, requestCode, resultCode, data!!)
        }
    }


    override fun onResume() {
        val preference1 = activity!!.getSharedPreferences("nickname", Context.MODE_PRIVATE)
        val name = preference1.getString("name", "")
        if (name != null && name != "") {
            tv_self_name.setText(name)
        }


        val preference2 = activity!!.getSharedPreferences("selfimage", Context.MODE_PRIVATE)
        val path = preference2.getString("path", "")
        val bitmap = BitmapFactory.decodeFile(path)
        iv_self_change_image.setImageBitmap(bitmap)


        val preference3 = activity!!.getSharedPreferences("introduce", Context.MODE_PRIVATE)
        val content = preference3.getString("content", "")
        if (content != null && content != "") {
            tv_self_detail.setText(content)
        }

        super.onResume()
    }

}
