package com.example.shop

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.shop.activity.LoginActivity
import com.example.shop.activity.MasukActivity
import com.example.shop.fragment.*
import com.example.shop.helper.SharedPref
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val FragmentBeranda : Fragment = BerandaFragment()
    private val FragmentAkun : Fragment = AkunFragment()
    private val FragmentKategori : Fragment = KategoriFragment()
    private val FragmentKeranjang : Fragment = KeranjangFragment()
    private val FM : FragmentManager = supportFragmentManager
    private var active : Fragment = FragmentBeranda


    private lateinit var menu: Menu
    private lateinit var menuitem: MenuItem
    private lateinit var bottomNavigationView : BottomNavigationView

    private var statuslogin = false

    private lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        s = SharedPref(this)
        setupBottomNav()
    }



    fun setupBottomNav(){
        FM.beginTransaction().add(R.id.container, FragmentBeranda).show(FragmentBeranda).commit()
        FM.beginTransaction().add(R.id.container, FragmentKategori).hide(FragmentKategori).commit()
        FM.beginTransaction().add(R.id.container, FragmentAkun).hide(FragmentAkun).commit()
        FM.beginTransaction().add(R.id.container, FragmentKeranjang).hide(FragmentKeranjang).commit()

        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuitem = menu.getItem(0)
        menuitem.isChecked = true



        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId){
                R.id.navigation_beranda->{

                    callfragment(0,FragmentBeranda)
                }
                R.id.navigation_kategori->{

                    callfragment(1,FragmentKategori)
                }
                R.id.navigation_akun->{
                    if(s.getstatuslogin()){
                        callfragment(2,FragmentAkun)
                    }else{
                        startActivity(Intent(this, MasukActivity::class.java))
                    }

                }
                R.id.navigation_lainnya->{

                    callfragment(3,FragmentKeranjang)
                }
            }

            false }

    }


    fun callfragment(int: Int, fragment: Fragment){
        menuitem = menu.getItem(int)
        menuitem.isChecked = true
        FM.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}