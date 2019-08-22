package com.mredrock.cyxbs.freshman.model

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mredrock.cyxbs.common.utils.extensions.setImageFromUrl
import com.mredrock.cyxbs.freshman.model.retrofit.ByIdEnity
import com.mredrock.cyxbs.freshman.model.retrofit.ClassIdService
import com.mredrock.cyxbs.freshman.ui.activity.StarActivity
import com.mredrock.cyxbs.freshman.utils.StarREcyclerAdapter
import kotlinx.android.synthetic.main.app_activity_detail.*
import kotlinx.android.synthetic.main.app_activity_star.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class StarModel {
    private val BASE_URL="https://api.jisuapi.com/"

    fun requestid(activity: StarActivity,id:ArrayList<Int>){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)//基础URL 建议以 / 结尾
            .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava 适配器
            .build()
        val classIdService=retrofit.create(ClassIdService::class.java)
        val images=ArrayList<String>()
        val names=ArrayList<String>()
        val contents=ArrayList<String>()
        for (i in 0 until id.size){
            classIdService.getById("detail",id.get(i))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<ByIdEnity>(){
                    override fun onNext(t: ByIdEnity) {
                        images.add(t.result.pic)
                        names.add(t.result.name)
                        contents.add(t.result.content)
                        val adapter=StarREcyclerAdapter(images,names,contents,id,activity)
                        val layoutManager=LinearLayoutManager(activity)
                        activity.star_recycler.adapter=adapter
                        activity.star_recycler.layoutManager=layoutManager
                        activity.star_recycler.addItemDecoration(DividerItemDecoration(activity,DividerItemDecoration.VERTICAL))
                    }

                    override fun onCompleted() {

                    }

                    override fun onError(e: Throwable?) {

                    }

                })
        }
    }
}