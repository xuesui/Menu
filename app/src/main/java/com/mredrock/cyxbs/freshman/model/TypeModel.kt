package com.mredrock.cyxbs.freshman.model

import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.TypeAdapter
import com.mredrock.cyxbs.freshman.model.retrofit.ClassIdEnity
import com.mredrock.cyxbs.freshman.model.retrofit.ClassIdService
import com.mredrock.cyxbs.freshman.ui.activity.TypeActivity
import com.mredrock.cyxbs.freshman.utils.TypeRecyclerAdapter
import kotlinx.android.synthetic.main.app_activity_type.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class TypeModel {
    private val BASE_URL = "https://api.jisuapi.com/"

    fun requestClassId(activity: TypeActivity,position:Int){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)//基础URL 建议以 / 结尾
            .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava 适配器
            .build()
        val classIdService = retrofit.create(ClassIdService::class.java)

        val classId=ArrayList<Int>()
        val title=ArrayList<String>()

        classIdService.getClassId("class")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Subscriber<ClassIdEnity>(){
                override fun onNext(t: ClassIdEnity) {
                   for (i in 0 until t.result[position].list.size){
                       classId.add(t.result[position].list[i].classid)
                       title.add(t.result[position].list[i].name)
                   }

                    val adapter=TypeRecyclerAdapter(title,classId,activity)
                    val layoutManager=LinearLayoutManager(activity)
                    activity.type_recycler.adapter=adapter
                    activity.type_recycler.layoutManager=layoutManager
                }

                override fun onCompleted() {

                }

                override fun onError(e: Throwable?) {

                }

            })
    }
}