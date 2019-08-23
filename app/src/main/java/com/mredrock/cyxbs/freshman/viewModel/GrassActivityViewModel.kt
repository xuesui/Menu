package com.mredrock.cyxbs.freshman.viewModel

import androidx.recyclerview.widget.GridLayoutManager
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.activity.GrassActivity
import com.mredrock.cyxbs.freshman.utils.GrassRecyclerAdapter
import kotlinx.android.synthetic.main.app_activity_grass.*

class GrassActivityViewModel : BaseViewModel() {
    private val title = arrayListOf(
        "滋阴鸭肉", "安神桂圆", "健脾山药", "应季花生", "黄金玉米", "丸子美食"
        , "童趣便当", "布丁", "果冻", "消暑棒棒冰", "纯天然手作冰沙", "深夜食堂"
        , "花样火锅", "就爱糖醋味", "苦瓜与夏天", "键康沙拉"
        , "梦幻杯子蛋糕", "coffee加油站", "夏日奶茶", "戒不掉的冰激凌"
    )

    private val food = arrayListOf(
        "鸭肉", "桂圆", "山药", "花生", "玉米", "丸子"
        , "便当", "布丁", "果冻", "冰棒", "冰沙", "烧烤", "火锅", "糖醋", "苦瓜", "沙拉"
        , "杯子蛋糕", "咖啡", "奶茶", "冰激凌"
    )

    private val imagepic= arrayListOf(R.drawable.yarou,R.drawable.guiyuan,R.drawable.shanyao
    ,R.drawable.huasheng,R.drawable.yumi,R.drawable.wanzi,R.drawable.biandang,R.drawable.buding,R.drawable.guodong
    ,R.drawable.bingbang,R.drawable.bingsha,R.drawable.shaokao,R.drawable.huoguo,R.drawable.tangcu,R.drawable.kugua
    ,R.drawable.shala,R.drawable.beizidangao,R.drawable.kafei,R.drawable.naicha,R.drawable.bingjiling)

    fun initView(activity: GrassActivity) {
        val adapter=GrassRecyclerAdapter(title,food,imagepic,activity)
        val layoutManager=GridLayoutManager(activity,3)
        activity.grass_recycler.adapter=adapter
        activity.grass_recycler.layoutManager=layoutManager
    }

}