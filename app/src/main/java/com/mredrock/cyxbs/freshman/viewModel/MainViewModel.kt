package com.mredrock.cyxbs.freshman.viewModel

import android.content.Context
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import cn.leancloud.AVObject
import cn.leancloud.AVQuery
import com.bumptech.glide.Glide
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.model.MainModel
import com.mredrock.cyxbs.freshman.ui.fragment.MainFragment
import com.mredrock.cyxbs.freshman.utils.MainRecyclerAdapter
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.loader.ImageLoader
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.app_main_fragment.*
import java.util.*
import kotlin.collections.ArrayList

class MainViewModel : BaseViewModel() {
    private var imageLoader=MyImageLoader()
    private var titles=ArrayList<String>()
    private var images=ArrayList<Int>()
    val mainModel = MainModel()

//自定义图片加载器
    private inner class MyImageLoader : ImageLoader() {
        override fun displayImage(context: Context, path: Any?, imageView: ImageView) {
            Glide.with(context.getApplicationContext())
                .load(path)
                .into(imageView);
        }
    }


    private fun initBannerData(fragment: MainFragment){
        images.add(R.drawable.banner1)
        images.add(R.drawable.banner2)
        images.add(R.drawable.banner3)
        titles.add("新鲜营养的食材")
        titles.add("丰富的烹饪技术")
        titles.add("食物的麻辣鲜香")
    }


    fun initBanner(fragment: MainFragment){
        initBannerData(fragment)
        fragment.banner_main.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
            .setImageLoader(imageLoader)
            .setBannerAnimation(Transformer.FlipHorizontal)
            .setBannerTitles(titles)
            .setDelayTime(3000)
            .setIndicatorGravity(BannerConfig.CENTER)
            .setImages(images)
            .start()
    }


    fun initRecyclerView(fragment: MainFragment) {
        mainModel.requestClassify(fragment)
    }

    fun initDaily(fragment: MainFragment,id:Int){
        mainModel.requestId(fragment,id)
    }

    fun refresh(fragment:MainFragment){
        val random= Random()
        fragment.refreshn_main.setColorSchemeResources(R.color.colorPrimary)
        fragment.refreshn_main.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener{
            override fun onRefresh() {
                val vid=random.nextInt(56383)
                initDaily(fragment,vid)

                val nid=random.nextInt(56383)
                initDaily(fragment,nid)
                Thread.sleep(100)
                fragment.refreshn_main.isRefreshing=false
            }

        })
    }
}
