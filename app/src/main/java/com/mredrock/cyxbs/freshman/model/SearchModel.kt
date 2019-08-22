package com.mredrock.cyxbs.freshman.model

import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.mredrock.cyxbs.freshman.model.retrofit.ClassIdService
import com.mredrock.cyxbs.freshman.model.retrofit.SearchEnity
import com.mredrock.cyxbs.freshman.ui.activity.SearchActivity
import com.mredrock.cyxbs.freshman.utils.StarREcyclerAdapter
import kotlinx.android.synthetic.main.app_activity_search.*
import kotlinx.android.synthetic.main.app_main_fragment.*
import org.greenrobot.eventbus.Subscribe
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class SearchModel {
    private val BASE_URL = "https://api.jisuapi.com/"


    fun search(activity: SearchActivity, content: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)//基础URL 建议以 / 结尾
            .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava 适配器
            .build()
        val classIdService = retrofit.create(ClassIdService::class.java)
        classIdService.search("search", 100, content)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Subscriber<SearchEnity>() {
                override fun onNext(t: SearchEnity) {
                    val contents = ArrayList<String>()
                    val names = ArrayList<String>()
                    val images = ArrayList<String>()
                    val ids = ArrayList<Int>()
                    for (i in 0 until t.result.list.size) {
                        contents.add(t.result.list[i].content)
                        names.add(t.result.list[i].name)
                        images.add(t.result.list[i].pic)
                        ids.add(t.result.list[i].id)
                    }
                    val adapter = StarREcyclerAdapter(images, names, contents, ids, activity)
                    val layoutManager = LinearLayoutManager(activity)
                    activity.search_recycler.adapter = adapter
                    activity.search_recycler.layoutManager = layoutManager
                }

                override fun onCompleted() {

                }

                override fun onError(e: Throwable?) {

                }

            })


    }

}
