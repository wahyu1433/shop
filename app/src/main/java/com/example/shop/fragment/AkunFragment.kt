package com.example.shop.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.shop.MainActivity
import com.example.shop.R
import com.example.shop.activity.LoginActivity
import com.example.shop.helper.SharedPref


class AkunFragment : Fragment() {

    lateinit var s:SharedPref
    lateinit var btnlogout:TextView
    lateinit var tvNama: TextView
    lateinit var tvEmail: TextView
    lateinit var tvPhone: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_akun, container, false)
        s = SharedPref(requireActivity())

        init(view)
        setData()



        btnlogout.setOnClickListener{
            s.setStatusLogin(false)
        }

        return view
    }

    private fun init(view: View) {
        btnlogout = view.findViewById(R.id.btn_logout)
        tvNama = view.findViewById(R.id.tv_nama)
        tvEmail = view.findViewById(R.id.tv_email)
        tvPhone = view.findViewById(R.id.tv_phone)
    }

    fun setData(){

        if (s.getUser() == null){
            val intent = Intent(activity, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            return
        }

        val user = s.getUser()!!
        tvNama.text = user.name
        tvEmail.text = user.email
        tvPhone.text = user.phone
    }


}