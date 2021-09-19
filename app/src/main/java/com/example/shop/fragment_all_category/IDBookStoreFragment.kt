package com.example.shop.fragment_all_category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.MainActivity
import com.example.shop.R
import com.example.shop.adapter.AdapterKeranjang
import com.example.shop.adapter.AdapterProduk
import com.example.shop.model.Produk
import com.example.shop.room.MyDatabase
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_category.*

class IDBookStoreFragment : Fragment() {


    lateinit var bottomnav : BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.idbookstore, container, false)

        return view
    }


    }
