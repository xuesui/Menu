package com.mredrock.cyxbs.freshman.viewModel

import android.content.Context
import android.content.Intent
import android.os.Bundle
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
import com.mredrock.cyxbs.freshman.model.SearchModel
import com.mredrock.cyxbs.freshman.ui.activity.DetailActivity
import com.mredrock.cyxbs.freshman.ui.activity.MoreRecommandActivity
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
    private val mainModel = MainModel()
    private val searchModel=SearchModel()

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

    fun initDaily(fragment: MainFragment,id:Int,which: Int){
        mainModel.requestId(fragment,id,which)
    }

    fun refresh(fragment:MainFragment){
        val random= Random()
        fragment.refreshn_main.setColorSchemeResources(R.color.colorPrimary)
        fragment.refreshn_main.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener{
            override fun onRefresh() {
                val vid=random.nextInt(56383)
                initDaily(fragment,vid,1)
                todetail(fragment,vid,1)

                val nid=random.nextInt(56383)
                initDaily(fragment,nid,2)
                todetail(fragment,nid,2)
                Thread.sleep(100)
                fragment.refreshn_main.isRefreshing=false
            }

        })
    }

    fun todetail(fragment: MainFragment,id:Int,which:Int){
        if (which==1){
            fragment.main_card1.setOnClickListener {
                val intent=Intent(fragment.context,DetailActivity::class.java)
                val bundle=Bundle()
                bundle.putInt("id",id)
                intent.putExtras(bundle)
                fragment.startActivity(intent)
            }
        }else if (which==2){
            fragment.main_card2.setOnClickListener {
                val intent=Intent(fragment.context,DetailActivity::class.java)
                val bundle=Bundle()
                bundle.putInt("id",id)
                intent.putExtras(bundle)
                fragment.startActivity(intent)
            }
        }

    }


    fun search(fragment: MainFragment){
        mainModel.search(fragment)
    }

    fun toMoreRecommand(fragment: MainFragment){
        fragment.tv_main_more.setOnClickListener {
            val intent=Intent(fragment.context,MoreRecommandActivity::class.java)
            val bundle=Bundle()
            bundle.putString("title","今日新品")
            intent.putExtras(bundle)
            fragment.startActivity(intent)
        }

        fragment.iv_mian_more.setOnClickListener {
            val intent=Intent(fragment.context,MoreRecommandActivity::class.java)
            val bundle=Bundle()
            bundle.putString("title","今日新品")
            intent.putExtras(bundle)
            fragment.startActivity(intent)
        }

        fragment.main_grass_card1.setOnClickListener {
            val intent=Intent(fragment.context,MoreRecommandActivity::class.java)
            val bundle=Bundle()
            bundle.putString("title","肉的盛宴")
            bundle.putString("food","肉")
            bundle.putInt("imagepic",R.drawable.redmeat)
            intent.putExtras(bundle)
            fragment.startActivity(intent)
        }

        fragment.main_grass_card2.setOnClickListener {
            val intent=Intent(fragment.context,MoreRecommandActivity::class.java)
            val bundle=Bundle()
            bundle.putString("title","特色小吃")
            bundle.putString("food","小吃")
            bundle.putInt("imagepic",R.drawable.snacks)
            intent.putExtras(bundle)
            fragment.startActivity(intent)
        }

        fragment.main_source_card.setOnClickListener{
            val intent=Intent(fragment.context,MoreRecommandActivity::class.java)
            val bundle=Bundle()
            bundle.putString("title","酱汁特色")
            bundle.putString("food","酱汁")
            bundle.putInt("imagepic",R.drawable.source)
            intent.putExtras(bundle)
            fragment.startActivity(intent)
        }

        fragment.main_mifen_card.setOnClickListener{
            val intent=Intent(fragment.context,MoreRecommandActivity::class.java)
            val bundle=Bundle()
            bundle.putString("title","寻味米粉")
            bundle.putString("food","米粉")
            bundle.putInt("imagepic",R.drawable.mifen)
            intent.putExtras(bundle)
            fragment.startActivity(intent)
        }

        fragment.main_sichuan_card.setOnClickListener{
            val intent=Intent(fragment.context,MoreRecommandActivity::class.java)
            val bundle=Bundle()
            bundle.putString("title","入川必吃")
            bundle.putString("food","四川")
            bundle.putInt("imagepic",R.drawable.sichuan)
            intent.putExtras(bundle)
            fragment.startActivity(intent)
        }

        fragment.main_dousha_card.setOnClickListener{
            val intent=Intent(fragment.context,MoreRecommandActivity::class.java)
            val bundle=Bundle()
            bundle.putString("title","甜味回忆")
            bundle.putString("food","豆沙")
            bundle.putInt("imagepic",R.drawable.dousha)
            intent.putExtras(bundle)
            fragment.startActivity(intent)
        }
    }


}
