package com.example.shop.fragment_all_category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.shop.R
import com.example.shop.activity.PagerActivity
import com.example.shop.adapter.AdapterKeranjang
import com.example.shop.adapter.AdapterPager
import com.example.shop.adapter.AdapterProduk
import com.example.shop.model.Produk
import com.example.shop.room.MyDatabase
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.inyongtisto.tutorial.adapter.AdapterSlider
import kotlinx.android.synthetic.main.view_pager.*

class Category1Fragment : Fragment() {





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.media_pembelajaran, container, false)



        return view
    }


}