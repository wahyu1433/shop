package com.example.shop.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.shop.fragment_all_category.*

class AdapterPager2(fragmentManager : FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 6
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                VistalksFragment()
            }
            1->{
                CreativeFragment()
            }
            2->{
                MedisainFragment()
            }
            3->{
                SensitifFragment()
            }
            4->{
                KoolineraFragment()
            }
            5->{
                LaBirdFragment()
            }
            else->{
                Fragment()
            }
    }
}
}