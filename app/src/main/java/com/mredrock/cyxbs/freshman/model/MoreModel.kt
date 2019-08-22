package com.mredrock.cyxbs.freshman.model

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mredrock.cyxbs.freshman.model.retrofit.ByIdEnity
import com.mredrock.cyxbs.freshman.model.retrofit.ClassIdService
import com.mredrock.cyxbs.freshman.ui.activity.MoreRecommandActivity
import com.mredrock.cyxbs.freshman.utils.MoreRecyclerAdapter
import com.mredrock.cyxbs.freshman.utils.StarREcyclerAdapter
import kotlinx.android.synthetic.main.app_activity_more_recommand.*
import kotlinx.android.synthetic.main.app_activity_star.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*
import kotlin.collections.ArrayList

class MoreModel {
    private val BASE_URL="https://api.jisuapi.com/"

    fun moreRecommand(activity: MoreRecommandActivity){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)//基础URL 建议以 / 结尾
            .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava 适配器
            .build()
        val classIdService=retrofit.create(ClassIdService::class.java)
        val images=ArrayList<String>()
        val names=ArrayList<String>()
        val contents=ArrayList<String>()
        val random= Random()
        val mInt=random.nextInt(55383)
        for (i in mInt until (mInt +1000)){
            classIdService.getById("detail",i)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<ByIdEnity>(){
                    override fun onNext(t: ByIdEnity) {
                        images.add(t.result.pic)
                        names.add(t.result.name)
                        contents.add(t.result.content)
                        val adapter= MoreRecyclerAdapter(images,names,contents,activity)
                        val layoutManager= LinearLayoutManager(activity)
                        activity.more_recyler.adapter=adapter
                        activity.more_recyler.layoutManager=layoutManager
                        activity.more_recyler.addItemDecoration(
                            DividerItemDecoration(activity,
                                DividerItemDecoration.VERTICAL)
                        )
                    }

                    override fun onCompleted() {

                    }

                    override fun onError(e: Throwable?) {

                    }

                })
        }
    }
}