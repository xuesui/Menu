package com.mredrock.cyxbs.freshman.model

import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mredrock.cyxbs.common.utils.extensions.setImageFromUrl
import com.mredrock.cyxbs.freshman.model.retrofit.ByIdEnity
import com.mredrock.cyxbs.freshman.model.retrofit.ClassIdService
import com.mredrock.cyxbs.freshman.ui.activity.DetailActivity
import com.mredrock.cyxbs.freshman.ui.fragment.DeatailHowFragment
import com.mredrock.cyxbs.freshman.ui.fragment.DetailContentFragment
import com.mredrock.cyxbs.freshman.ui.fragment.DetailFromFragment
import com.mredrock.cyxbs.freshman.utils.DetailRecyclerAdapter
import com.mredrock.cyxbs.freshman.utils.FromRecyclerAdapter
import kotlinx.android.synthetic.main.app_activity_detail.*
import kotlinx.android.synthetic.main.app_detail_content_fragment.*
import kotlinx.android.synthetic.main.app_detail_from_fragment.*
import kotlinx.android.synthetic.main.appdeatail_how_fragment.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class DetailModel {
    private val BASE_URL="https://api.jisuapi.com/"

    fun requestId(activity: DetailActivity,id:Int){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)//基础URL 建议以 / 结尾
            .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava 适配器
            .build()

        val classIdService=retrofit.create(ClassIdService::class.java)
        classIdService.getById("detail",id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Subscriber<ByIdEnity>(){
                override fun onNext(t: ByIdEnity) {
                    val name=t.result.name
                    val pic=t.result.pic
                    val tag=t.result.peoplenum
                    val prepare=t.result.preparetime
                    val time=t.result.cookingtime
                    activity. detail_collapsing_toolbar.title=name
                    activity.detail_iv_top.setImageFromUrl(pic)
                    activity.tv_detail_name.setText(name)
                    activity.tv_detail_prepare.setText(prepare)
                    activity.tv_detail_cook.setText(time)
                    activity.tv_detail_tag.setText(tag)
                }

                override fun onCompleted() {

                }

                override fun onError(e: Throwable?) {

                }

            })
    }

    fun requestId(fragment: DeatailHowFragment,id: Int){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)//基础URL 建议以 / 结尾
            .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava 适配器
            .build()

        val classIdService=retrofit.create(ClassIdService::class.java)
        classIdService.getById("detail",id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Subscriber<ByIdEnity>(){
                override fun onNext(t: ByIdEnity) {
                    val content=ArrayList<String>()
                    val pic=ArrayList<String>()
                    for (i in 0 until t.result.process.size){
                        content.add(t.result.process[i].pcontent)
                        pic.add(t.result.process[i].pic)
                        Log.d("RRR","ll"+pic.get(i))
                    }
                    val adpter=DetailRecyclerAdapter(pic,content, fragment.context!!)
                    val layoutManager=LinearLayoutManager(fragment.context)
                    fragment.recycler_detail_how.layoutManager=layoutManager
                    fragment.recycler_detail_how.adapter=adpter

                }

                override fun onCompleted() {

                }

                override fun onError(e: Throwable?) {

                }

            })
    }


    fun requestId(fragment: DetailFromFragment,id: Int){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)//基础URL 建议以 / 结尾
            .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava 适配器
            .build()

        val classIdService=retrofit.create(ClassIdService::class.java)
        classIdService.getById("detail",id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Subscriber<ByIdEnity>(){
                override fun onNext(t: ByIdEnity) {
                    val name=ArrayList<String>()
                    val weight=ArrayList<String>()
                    for (i in 0 until t.result.material.size){
                        name.add(t.result.material[i].mname)
                        weight.add(t.result.material[i].amount)
                    }
                    val adpter=FromRecyclerAdapter(name,weight)
                    val layoutManager=LinearLayoutManager(fragment.context)
                    fragment.recycler_detail_from.layoutManager=layoutManager
                    fragment.recycler_detail_from.adapter=adpter
                    fragment.recycler_detail_from.addItemDecoration(DividerItemDecoration(fragment.context,DividerItemDecoration.VERTICAL))
                }

                override fun onCompleted() {

                }

                override fun onError(e: Throwable?) {

                }

            })
    }


    fun requestId(fragment: DetailContentFragment,id: Int){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)//基础URL 建议以 / 结尾
            .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava 适配器
            .build()

        val classIdService=retrofit.create(ClassIdService::class.java)
        classIdService.getById("detail",id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Subscriber<ByIdEnity>(){
                override fun onNext(t: ByIdEnity) {
                    val content=t.result.content
                    val tag=t.result.tag
                    fragment.tv_detail_content_content.setText(content)
                    fragment.tv_detail_content_tag.setText(tag)
                }

                override fun onCompleted() {

                }

                override fun onError(e: Throwable?) {

                }

            })
    }
}