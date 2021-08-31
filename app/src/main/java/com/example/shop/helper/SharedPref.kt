package com.example.shop.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.example.shop.model.User
import com.google.gson.Gson

class SharedPref(activity:Activity) {
    val mypref = "Main_PRF"
    val sp:SharedPreferences

    val login  = "login"
    val nama = "nama"
    val phone = "phone"
    val email = "email"
    val user = "user"

    init {
        sp = activity.getSharedPreferences(mypref, Context.MODE_PRIVATE)
    }

    fun setStatusLogin(status:Boolean){
        sp.edit().putBoolean(login, status).apply()
    }

    fun getstatuslogin():Boolean{
        return sp.getBoolean(login, false)
    }

    fun setUser(value: User){
        val data: String = Gson().toJson(value, User::class.java)
        sp.edit().putString(user,data).apply()
    }

    fun getUser(): User?{
        val data: String = sp.getString(user,null) ?: return null
        val json = Gson().fromJson<User>(data, User::class.java)
        return json
    }

    fun setString(key: String, value: String){
        sp.edit().putString(key, value).apply()
    }

    fun getString(key: String): String{
        return sp.getString(key, "")!!
    }
}