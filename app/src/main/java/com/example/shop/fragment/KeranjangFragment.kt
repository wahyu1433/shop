package com.example.shop.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.R
import com.example.shop.adapter.AdapterKeranjang
import com.example.shop.adapter.AdapterProduk
import com.example.shop.model.Produk
import com.example.shop.room.MyDatabase

class KeranjangFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_keranjang, container, false)
        init(view)

        mainButton()
        displayProduk()
        return view
    }

    private fun mainButton(){
        btnDelete.setOnClickListener {

        }
        btnBayar.setOnClickListener {

        }
    }


    lateinit var adapter: AdapterKeranjang
    var listProduk = ArrayList<Produk>()
    private fun displayProduk(){

        //ambil data
        val myDB = MyDatabase.getInstance(requireActivity())
        val listProduk = myDB!!.daoKeranjang().getAll() as ArrayList

        val layoutmanager = LinearLayoutManager(activity)
        layoutmanager.orientation = LinearLayoutManager.VERTICAL

        rvProduk.adapter = AdapterKeranjang(requireActivity(),listProduk, object : AdapterKeranjang.Listeners{
            override fun onUpdate() {

            }

            override fun onDelete(position: Int) {

            }

            override fun onDelete() {

            }
        })
        rvProduk.layoutManager = layoutmanager
    }


    lateinit var btnDelete: ImageView
    lateinit var rvProduk : RecyclerView
    lateinit var tvTotal : TextView
    lateinit var btnBayar : TextView
    fun init(view: View){
        btnDelete = view.findViewById(R.id.btn_delete)
        btnBayar = view.findViewById(R.id.btn_bayar)
        tvTotal = view.findViewById(R.id.tv_total)
        rvProduk = view.findViewById(R.id.rv_produk)
    }

    override fun onResume(){
        displayProduk()
        super.onResume()
    }

}