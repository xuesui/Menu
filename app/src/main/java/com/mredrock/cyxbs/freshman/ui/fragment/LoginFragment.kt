package com.mredrock.cyxbs.freshman.ui.fragment

import android.content.Intent
import android.graphics.Color
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mredrock.cyxbs.common.ui.BaseViewModelFragment
import com.mredrock.cyxbs.freshman.ui.activity.MainActivity

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.app_activity_login.*
import kotlinx.android.synthetic.main.app_login_fragment.*
import org.jetbrains.anko.backgroundColor

class LoginFragment : BaseViewModelFragment<LoginViewModel>() {
    override val viewModelClass: Class<LoginViewModel>
        get() = LoginViewModel::class.java

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.app_login_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        viewModel.doToEdit(this)
        viewModel.OnClickLisner(this)
    }
}
