package com.example.shop.app

import com.example.shop.model.ResponModel
import okhttp3.Call
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.POST
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("email") email : String,
        @Field("password") password :  String,
        @Field("name") name :  String,
        @Field("phone") phone :  String
    ):retrofit2.Call<ResponModel>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email : String,
        @Field("password") password :  String,
    ):retrofit2.Call<ResponModel>

    @GET("produk")
    fun getProduk():retrofit2.Call<ResponModel>
}