package com.mredrock.cyxbs.freshman.model

import android.graphics.Color
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.common.utils.extensions.setImageFromUrl
import com.mredrock.cyxbs.freshman.litepal.Star
import com.mredrock.cyxbs.freshman.model.retrofit.ByIdEnity
import com.mredrock.cyxbs.freshman.model.retrofit.ClassIdService
import com.mredrock.cyxbs.freshman.ui.activity.PastActivity
import com.mredrock.cyxbs.freshman.ui.activity.StarActivity
import com.mredrock.cyxbs.freshman.utils.StarREcyclerAdapter
import com.yanzhenjie.recyclerview.touch.OnItemMoveListener
import com.yanzhenjie.recyclerview.widget.DefaultItemDecoration
import kotlinx.android.synthetic.main.app_activity_detail.*
import kotlinx.android.synthetic.main.app_activity_past.*
import kotlinx.android.synthetic.main.app_activity_star.*
import org.litepal.crud.DataSupport
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*
import java.util.Collections.swap
import kotlin.collections.ArrayList


class StarModel {
    private val BASE_URL = "https://api.jisuapi.com/"

    fun requestid(activity: StarActivity, id: ArrayList<Int>,iId:ArrayList<Int>) {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)//基础URL 建议以 / 结尾
            .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava 适配器
            .build()
        val classIdService = retrofit.create(ClassIdService::class.java)
        val images = ArrayList<String>()
        val names = ArrayList<String>()
        val contents = ArrayList<String>()
        val ids = ArrayList<Int>()
        for (i in 0 until id.size) {
            classIdService.getById("detail", id.get(i))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<ByIdEnity>() {
                    override fun onNext(t: ByIdEnity) {
                        images.add(t.result.pic)
                        names.add(t.result.name)
                        contents.add(t.result.content)
                        ids.add(t.result.id)
                        val adapter = StarREcyclerAdapter(images, names, contents, ids, activity)
                        val layoutManager = LinearLayoutManager(activity)
                        activity.star_recycler.adapter = adapter
                        activity.star_recycler.layoutManager = layoutManager
                        val itemDecoration: RecyclerView.ItemDecoration =
                            DefaultItemDecoration(Color.parseColor("#e6e6e6"))
                        activity.star_recycler.addItemDecoration(itemDecoration)
                        activity.star_recycler.isLongPressDragEnabled = true
                        activity.star_recycler.isItemViewSwipeEnabled = true
                        val itemMoveListener = object : OnItemMoveListener {
                            override fun onItemDismiss(srcHolder: RecyclerView.ViewHolder) {
                                val position = srcHolder.getAdapterPosition()
                                images.removeAt(position)
                                names.removeAt(position)
                                contents.removeAt(position)
                                ids.removeAt(position)
                                adapter.notifyItemRemoved(position)
                                DataSupport.delete(Star::class.java, iId.get(position).toLong())
                            }

                            override fun onItemMove(
                                srcHolder: RecyclerView.ViewHolder,
                                targetHolder: RecyclerView.ViewHolder
                            ): Boolean {
                                val fromPosition = srcHolder.getAdapterPosition()
                                val toPosition = targetHolder.getAdapterPosition()
                                Collections.swap(images, fromPosition, toPosition)
                                Collections.swap(names, fromPosition, toPosition)
                                Collections.swap(contents, fromPosition, toPosition)
                                Collections.swap(ids, fromPosition, toPosition)
                                adapter.notifyItemMoved(fromPosition, toPosition)

                                return true
                            }
                        }

                        activity.star_recycler.setOnItemMoveListener(itemMoveListener)
                    }

                        override fun onCompleted() {

                        }

                        override fun onError(e: Throwable?) {

                        }

                    })
                }
        }


        fun requestid(activity: PastActivity, id: ArrayList<Int>) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)//基础URL 建议以 / 结尾
                .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava 适配器
                .build()
            val classIdService = retrofit.create(ClassIdService::class.java)
            val images = ArrayList<String>()
            val names = ArrayList<String>()
            val contents = ArrayList<String>()
            val ids = ArrayList<Int>()
            for (i in 0 until id.size) {
                classIdService.getById("detail", id.get(i))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : Subscriber<ByIdEnity>() {
                        override fun onNext(t: ByIdEnity) {
                            images.add(t.result.pic)
                            names.add(t.result.name)
                            contents.add(t.result.content)
                            ids.add(t.result.id)
                            val adapter =
                                StarREcyclerAdapter(images, names, contents, ids, activity)
                            val layoutManager = LinearLayoutManager(activity)
                            activity.past_recycler.adapter = adapter
                            activity.past_recycler.layoutManager = layoutManager
                            activity.past_recycler.addItemDecoration(
                                DividerItemDecoration(
                                    activity,
                                    DividerItemDecoration.VERTICAL
                                )
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