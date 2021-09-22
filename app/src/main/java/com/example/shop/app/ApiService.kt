package com.example.shop.app

import com.example.shop.model.Checkout
import com.example.shop.model.ResponModel
import okhttp3.Call
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.*

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


    //mulai dari sini
    @POST("Checkout")
    fun checkout(
        @Body data: Checkout
    ):retrofit2.Call<ResponModel>

    @GET("checkout/user/{id}")
    fun getRiwayat(
        @Path("id") id: Int
    ): retrofit2.Call<ResponModel>

    @POST("checkout/batal/{id}")
    fun batalCheckout(
        @Path("id") id: Int
    ): retrofit2.Call<ResponModel>
}