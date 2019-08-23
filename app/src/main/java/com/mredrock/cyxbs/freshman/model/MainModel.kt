package com.mredrock.cyxbs.freshman.model

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import cn.leancloud.AVObject
import com.bumptech.glide.Glide
import com.mredrock.cyxbs.common.utils.extensions.setImageFromUrl
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.model.retrofit.ByIdEnity
import com.mredrock.cyxbs.freshman.model.retrofit.ClassIdEnity
import com.mredrock.cyxbs.freshman.model.retrofit.ClassIdService
import com.mredrock.cyxbs.freshman.ui.activity.SearchActivity
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
    private var content=""

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

                    val adapter= MainRecyclerAdapter(pivtures, names,fragment.context!!)
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


    override fun requestId(fragment: MainFragment,id:Int,which:Int) {
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
                  if (which==1){
                      fragment.tv_main_daily_name1.setText(name)
                      fragment.tv_main_daily_content1.setText(content)
                      fragment.iv_main_daily_recommand1.setImageFromUrl(image)
                  }else if (which==2){
                      fragment.tv_main_daily_name2.setText(name)
                      fragment.tv_main_daily_content2.setText(content)
                      Glide.with(fragment).load(image).into(fragment.iv_main_daily_recommand2)
                  }
                }

                override fun onCompleted() {

                }

                override fun onError(e: Throwable?) {

                }

            })
    }

    fun search(fragment: MainFragment){
        fragment.et_main.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString()!=""){
                    fragment.tv_main_search.visibility= View.VISIBLE
                    content=p0.toString()
                }else{
                    fragment.tv_main_search.visibility= View.INVISIBLE
                }
            }
        })

        fragment.tv_main_search.setOnClickListener {
            val intent=Intent(fragment.context,SearchActivity::class.java)
            val bundle=Bundle()
            bundle.putString("content",content)
            intent.putExtras(bundle)
            fragment.startActivity(intent)
        }
    }

}