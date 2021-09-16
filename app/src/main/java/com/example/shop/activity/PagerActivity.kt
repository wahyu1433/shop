package com.example.shop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.widget.ViewPager2
import com.example.shop.R
import com.example.shop.adapter.AdapterPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_pager)

        adapter()
    }

    fun adapter(){
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewpager2 = findViewById<ViewPager2>(R.id.view_pager2)

        val adapter= AdapterPager(supportFragmentManager, lifecycle)

        viewpager2.adapter = adapter

        TabLayoutMediator(tabLayout, viewpager2){tab, position->
            when(position){

                0->{
                    tab.text="Umocs"
                }
                1->{
                    tab.text = "Muse Academy"
                }
            }
        }.attach()
    }

}