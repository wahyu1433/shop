package com.example.shop.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.R
import com.example.shop.activity.MasukActivity
import com.example.shop.adapter.AdapterKeranjang
import com.example.shop.adapter.AdapterProduk
import com.example.shop.helper.Helper
import com.example.shop.helper.SharedPref
import com.example.shop.model.Produk
import com.example.shop.room.MyDatabase

class KeranjangFragment : Fragment() {

    lateinit var myDB: MyDatabase
    lateinit var s: SharedPref


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_keranjang, container, false)
        init(view)

        myDB = MyDatabase.getInstance(requireActivity())!!
        s = SharedPref(requireActivity())

        mainButton()
        displayProduk()
        return view
    }

    private fun mainButton(){
        btnDelete.setOnClickListener {

        }
        btnBayar.setOnClickListener {
            if (s.getstatuslogin()) {
                var isThereProduk = false
                for (p in listProduk) {
                    if (p.selected) isThereProduk = true
                }
            } else {
                requireActivity().startActivity(Intent(requireActivity(), MasukActivity::class.java))
            }
        }
        cball.setOnClickListener {
            for(i in listProduk.indices){
                val produk = listProduk[i]
                produk.selected = cball.isChecked
                listProduk[i] = produk
            }
            adapter.notifyDataSetChanged()
        }
    }


    lateinit var adapter: AdapterKeranjang
    var listProduk = ArrayList<Produk>()
    private fun displayProduk(){

        //ambil data
//        val myDB = MyDatabase.getInstance(requireActivity())
        listProduk = myDB.daoKeranjang().getAll() as ArrayList

        val layoutmanager = LinearLayoutManager(activity)
        layoutmanager.orientation = LinearLayoutManager.VERTICAL

        adapter = AdapterKeranjang(requireActivity(),listProduk, object : AdapterKeranjang.Listeners{
            override fun onUpdate() {
                total()
            }

            override fun onDelete(position: Int) {
                listProduk.removeAt(position)
                adapter.notifyDataSetChanged()
                total()
            }

        })
        rvProduk.adapter = adapter
        rvProduk.layoutManager = layoutmanager
    }


    fun total(){
//        val myDB = MyDatabase.getInstance(requireActivity())
        val listProduk = myDB.daoKeranjang().getAll() as ArrayList
        var totalharga = 0
        var isselectall = true
        for(produk in listProduk){
            if(produk.selected) {
                val harga = (Integer.valueOf(produk.harga))
                totalharga += (harga * produk.jumlah)
            }else{
                isselectall = false
            }
        }

        cball.isChecked = isselectall

        tvTotal.text = Helper().gantiRupiah(totalharga)
    }


    lateinit var btnDelete: ImageView
    lateinit var rvProduk : RecyclerView
    lateinit var tvTotal : TextView
    lateinit var btnBayar : TextView
    lateinit var cball: CheckBox
    fun init(view: View){
        btnDelete = view.findViewById(R.id.btn_delete)
        btnBayar = view.findViewById(R.id.btn_bayar)
        tvTotal = view.findViewById(R.id.tv_total)
        rvProduk = view.findViewById(R.id.rv_produk)
        cball = view.findViewById(R.id.cb_all)
    }

    override fun onResume(){
        displayProduk()
        total()
        super.onResume()
    }

}