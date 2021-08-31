package com.example.shop.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shop.R
import com.example.shop.helper.SharedPref
import kotlinx.android.synthetic.main.activity_masuk.*

class MasukActivity : AppCompatActivity() {

    lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)


        s = SharedPref(this)
        mainButton()

    }

    private fun mainButton(){

        btn_login_proses.setOnClickListener{
            startActivity(Intent(this,  LoginActivity::class.java))
        }

        btn_register.setOnClickListener{
            startActivity(Intent(this,  RegisterActivity::class.java))
        }
    }
}