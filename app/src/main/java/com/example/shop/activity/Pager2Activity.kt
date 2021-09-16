package com.example.shop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.widget.ViewPager2
import com.example.shop.R
import com.example.shop.adapter.AdapterPager
import com.example.shop.adapter.AdapterPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Pager2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_pager2)

        adapter()
    }

    fun adapter(){
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewpager3 = findViewById<ViewPager2>(R.id.view_pager3)

        val adapter= AdapterPager2(supportFragmentManager, lifecycle)

        viewpager3.adapter = adapter

        TabLayoutMediator(tabLayout, viewpager3){tab, position->
            when(position){

                0->{
                    tab.text="Vistalks"
                }
                1->{
                    tab.text = "Creaetive"
                }
                2->{
                    tab.text = "Medisain"
                }
                3->{
                    tab.text = "Sensitif"
                }
                4->{
                    tab.text = "Koolinera"
                }
                5->{
                    tab.text = "La Bird"
                }
            }
        }.attach()
    }

}