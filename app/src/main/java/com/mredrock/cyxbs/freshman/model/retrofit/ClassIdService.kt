package com.mredrock.cyxbs.freshman.model.retrofit

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface ClassIdService {
    @GET("recipe/{path}?appkey=7c258c3c1c0ad1e6")
    fun getClassId(@Path("path")path:String):Observable<ClassIdEnity>

    @GET("recipe/{path}?appkey=7c258c3c1c0ad1e6")
    fun getByClassId(@Path("path")path: String,@Query("classid")classid:Int,@Query("start")strart:Int,
                     @Query("num")num:Int):Observable<ByClassIdEnity>

    @GET("recipe/{path}?appkey=7c258c3c1c0ad1e6")
    fun getById(@Path("path")path: String,@Query("id")id:Int):Observable<ByIdEnity>

    @GET("recipe/{path}?appkey=7c258c3c1c0ad1e6")
    fun search(@Path("path")path: String,@Query("num")num: Int,@Query("keyword")keyword:String):Observable<SearchEnity>
}