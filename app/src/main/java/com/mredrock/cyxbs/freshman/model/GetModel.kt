package com.mredrock.cyxbs.freshman.model

import com.mredrock.cyxbs.freshman.ui.fragment.MainFragment

//让viewModel能和Model交互的接口
interface GetModel {
    //分类
    fun requestClassify(fragment: MainFragment)

    fun requestId(fragment: MainFragment,id:Int,which:Int)

}