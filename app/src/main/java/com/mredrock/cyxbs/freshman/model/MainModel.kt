package com.mredrock.cyxbs.freshman.model

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import cn.leancloud.AVObject
import com.bumptech.glide.Glide
import com.mredrock.cyxbs.common.utils.extensions.setImageFromUrl
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.model.retrofit.ByIdEnity
import com.mredrock.cyxbs.freshman.model.retrofit.ClassIdEnity
import com.mredrock.cyxbs.freshman.model.retrofit.ClassIdService
import com.mredrock.cyxbs.freshman.ui.fragment.MainFragment
import com.mredrock.cyxbs.freshman.utils.MainRecyclerAdapter
import kotlinx.android.synthetic.main.app_main_fragment.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainModel : GetModel {
    private val BASE_URL="https://api.jisuapi.com/"
    private var num=1

    override fun requestClassify(fragment: MainFragment) {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)//基础URL 建议以 / 结尾
            .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava 适配器
            .build()

        val classIdService=retrofit.create(ClassIdService::class.java)
        classIdService.getClassId("class")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Subscriber<ClassIdEnity>(){
                override fun onNext(t: ClassIdEnity) {
                    val names= ArrayList<String>()
                    for(i in 0 until t.result.size){
                        names.add(t.result[i].name)
                    }
                    val pivtures= arrayListOf(
                        R.drawable.juice, R.drawable.dumplin, R.drawable.cookie, R.drawable.tea, R.drawable.crime,
                        R.drawable.tea, R.drawable.frenchfrice, R.drawable.chicken, R.drawable.nudles, R.drawable.sandwich)

                    val adapter= MainRecyclerAdapter(pivtures, names)
                    val layoutManager= LinearLayoutManager(fragment.context)
                    layoutManager.orientation= LinearLayoutManager.HORIZONTAL
                    fragment.recycler_main.adapter=adapter
                    fragment.recycler_main.layoutManager=layoutManager
                }

                override fun onCompleted() {

                }

                override fun onError(e: Throwable?) {

                }

            })
    }


    override fun requestId(fragment: MainFragment,id:Int) {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)//基础URL 建议以 / 结尾
            .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava 适配器
            .build()
        val classIdService=retrofit.create(ClassIdService::class.java)
        classIdService.getById("detail",id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Subscriber<ByIdEnity>(){
                override fun onNext(t: ByIdEnity) {
                    val name=t.result.name
                    val content=t.result.content
                    val image=t.result.pic
                  if (num==1){
                      fragment.tv_main_daily_name1.setText(name)
                      fragment.tv_main_daily_content1.setText(content)
                      fragment.iv_main_daily_recommand1.setImageFromUrl(image)
                      num=2
                  }else if (num==2){
                      fragment.tv_main_daily_name2.setText(name)
                      fragment.tv_main_daily_content2.setText(content)
                      Glide.with(fragment).load(image).into(fragment.iv_main_daily_recommand2)
                      num=1
                  }
                }

                override fun onCompleted() {

                }

                override fun onError(e: Throwable?) {

                }

            })
    }

}