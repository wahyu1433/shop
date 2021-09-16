package com.example.shop.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.replace
import com.example.shop.R
import com.example.shop.activity.Pager2Activity
import com.example.shop.activity.PagerActivity
import com.example.shop.fragment_all_category.Category1Fragment
import com.example.shop.fragment_all_category.IDBookStoreFragment


class KategoriFragment : Fragment() {

    lateinit var category1 : CardView
    lateinit var category2 : CardView
    lateinit var category3 : CardView
    lateinit var category4 : CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_category, container, false)

        init(view)

        return view
    }

    private fun init(view: View) {
        category1 = view.findViewById(R.id.category_1)
        category2 = view.findViewById(R.id.category_2)
        category3 = view.findViewById(R.id.category_3)
        category4 = view.findViewById(R.id.category_4)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val category1Fragment = Category1Fragment()
        category1.setOnClickListener {

            val intent = Intent(activity, PagerActivity::class.java)
            startActivity(intent)
//            fragmentManager?.beginTransaction()?.apply {
////                replace(R.id.container, category1Fragment, Category1Fragment::class.java.simpleName)
////                    .addToBackStack(null)
////                    .commit()
//
//
//            }
        }
        category2.setOnClickListener {
//            val idbookstore = IDBookStoreFragment()
//            fragmentManager?.beginTransaction()?.apply {
//                replace(R.id.container, idbookstore, IDBookStoreFragment::class.java.simpleName)
//                    .addToBackStack(null)
//                    .commit()

//            val intent = Intent(activity, PagerActivity::class.java)
//            startActivity(intent)
            }

        category3.setOnClickListener {


            val intent = Intent(activity, IDBookStoreFragment::class.java)
            startActivity(intent)
        }

        category4.setOnClickListener {

            val intent = Intent(activity, Pager2Activity::class.java)
            startActivity(intent)
        }

    }



}