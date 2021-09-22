package com.example.shop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.shop.R
import com.example.shop.adapter.AdapterPager3
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Pager3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_pager3)

        adapter()
    }

    fun adapter(){
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewpager4 = findViewById<ViewPager2>(R.id.view_pager4)

        val adapter= AdapterPager3(supportFragmentManager, lifecycle)

        viewpager4.adapter = adapter

        TabLayoutMediator(tabLayout, viewpager4){tab, position->
            when(position){

                0->{
                    tab.text="IDBookStore"
                }
            }
        }.attach()
    }
}