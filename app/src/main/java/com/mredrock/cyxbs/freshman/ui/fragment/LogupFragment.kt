package com.mredrock.cyxbs.freshman.ui.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mredrock.cyxbs.common.ui.BaseViewModelFragment

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewModel.LogupViewModel
import kotlinx.android.synthetic.main.app_logup_fragment.*

class LogupFragment : BaseViewModelFragment<LogupViewModel>() {
    override val viewModelClass: Class<LogupViewModel>
        get() = LogupViewModel::class.java

    companion object {
        fun newInstance() = LogupFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.app_logup_fragment, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LogupViewModel::class.java)
        viewModel.doToEdit(this)
        viewModel.clickListener(this)
    }
}
