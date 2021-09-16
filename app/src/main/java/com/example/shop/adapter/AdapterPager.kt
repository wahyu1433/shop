package com.example.shop.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.shop.fragment_all_category.Category1Fragment
import com.example.shop.fragment_all_category.IDBookStoreFragment
import com.example.shop.fragment_all_category.MuseFragment

class AdapterPager(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {

    return when(position){
        0->{
            Category1Fragment()
        }
        1->{
            MuseFragment()
        }
        else->{
            Fragment()
        }


    }    }

}