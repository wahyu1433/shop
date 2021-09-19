package com.example.shop.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.shop.R

class GantiPasswordFragment : Fragment() {

    lateinit var submit: Button
    lateinit var passbaru: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_ganti_password, container, false)

        init(view)

        return view
    }

    private fun init(view: View){
        submit = view.findViewById(R.id.btn_submit)
        passbaru = view.findViewById(R.id.edt_password_baru)
    }
}