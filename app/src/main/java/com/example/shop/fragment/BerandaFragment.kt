package com.example.shop.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.shop.R
import com.example.shop.adapter.AdapterProduk
import com.example.shop.app.ApiConfig
import com.example.shop.model.Produk
import com.example.shop.model.ResponModel
import com.inyongtisto.tutorial.adapter.AdapterSlider
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BerandaFragment : Fragment() {



    lateinit var vpslider: ViewPager
    lateinit var rvProduk: RecyclerView
    lateinit var rvProdukTerlaris: RecyclerView
    lateinit var rvProdukElektronik: RecyclerView

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_beranda, container, false)

        initview(view)
        getProduk()




        return view
    }

    fun display(){

        //array slider
        val arrslide = ArrayList<Int>()
        arrslide.add(R.drawable.slider1)
        arrslide.add(R.drawable.slider2)
        arrslide.add(R.drawable.slider3)


        val adapterslider = AdapterSlider(arrslide, activity)
        vpslider.adapter = adapterslider

        val layoutmanager = LinearLayoutManager(activity)
        layoutmanager.orientation = LinearLayoutManager.HORIZONTAL

        val layoutmanager1 = LinearLayoutManager(activity)
        layoutmanager1.orientation = LinearLayoutManager.HORIZONTAL

        val layoutmanager2 = LinearLayoutManager(activity)
        layoutmanager2.orientation = LinearLayoutManager.HORIZONTAL

        rvProduk.adapter = AdapterProduk(requireActivity(),listProduk)
        rvProduk.layoutManager = layoutmanager

        rvProdukTerlaris.adapter = AdapterProduk(requireActivity(),listProduk)
        rvProdukTerlaris.layoutManager = layoutmanager1

        rvProdukElektronik.adapter = AdapterProduk(requireActivity(),listProduk)
        rvProdukElektronik.layoutManager = layoutmanager2

    }

    private var listProduk: ArrayList<Produk> = ArrayList()

    fun getProduk(){
        ApiConfig.instanceRetrofit.getProduk().enqueue(object:
            Callback<ResponModel> {
            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                val res = response.body()!!
                if (res.success == 1) {
                    val arrayProduk = ArrayList<Produk>()
                    for (p in res.produks) {
                        p.discount = 100000
                        arrayProduk.add(p)
                    }
                    listProduk = arrayProduk
                    display()
                }
            }

            override fun onFailure(call: Call<ResponModel>, t: Throwable) {

            }

        })
    }

    fun initview(view: View){
        vpslider = view.findViewById(R.id.vp_slider)
        rvProduk = view.findViewById(R.id.rv_produk)
        rvProdukTerlaris = view.findViewById(R.id.rv_produk_terlaris)
        rvProdukElektronik = view.findViewById(R.id.rv_produk_elektronik)
    }

//    val arrProduk: ArrayList<Produk>get(){
//        val arr = ArrayList<Produk>()
//        val p1 = Produk()
//        p1.nama = "ASUS ROG"
//        p1.harga = "Rp.25.600.000"
//        p1.gambar = R.drawable.asus
//
//        val p2 = Produk()
//        p2.nama = "Acer Swift"
//        p2.harga = "Rp.19.250.000"
//        p2.gambar = R.drawable.acer
//
//        val p3 = Produk()
//        p3.nama = "Apple"
//        p3.harga = "Rp31.560.000"
//        p3.gambar = R.drawable.apple
//
//        val p4 = Produk()
//        p4.nama = "Huawai"
//        p4.harga = "Rp.28.900.000"
//        p4.gambar = R.drawable.huawai
//
//
//        arr.add(p1)
//        arr.add(p2)
//        arr.add(p3)
//        arr.add(p4)
//
//        return arr
//    }
//    val arrProdukTerlaris: ArrayList<Produk>get(){
//        val arr = ArrayList<Produk>()
//        val p1 = Produk()
//        p1.nama = "Tas Backpacker"
//        p1.harga = "Rp.25.600.000"
//        p1.gambar = R.drawable.asus
//
//        val p2 = Produk()
//        p2.nama = "Jam Tangan SAMSUNG"
//        p2.harga = "Rp.19.250.000"
//        p2.gambar = R.drawable.acer
//
//        val p3 = Produk()
//        p3.nama = "Apple 12 Pro Max"
//        p3.harga = "Rp31.560.000"
//        p3.gambar = R.drawable.apple
//
//        val p4 = Produk()
//        p4.nama = "Realme GT"
//        p4.harga = "Rp.28.900.000"
//        p4.gambar = R.drawable.huawai
//
//
//        arr.add(p1)
//        arr.add(p2)
//        arr.add(p3)
//        arr.add(p4)
//
//        return arr
//    }
//    val arrProdukElektronik: ArrayList<Produk>get(){
//        val arr = ArrayList<Produk>()
//        val p1 = Produk()
//        p1.nama = "TV LED"
//        p1.harga = "Rp.25.600.000"
//        p1.gambar = R.drawable.asus
//
//        val p2 = Produk()
//        p2.nama = "Spaker Dual"
//        p2.harga = "Rp.19.250.000"
//        p2.gambar = R.drawable.acer
//
//        val p3 = Produk()
//        p3.nama = "Sound Full Bass"
//        p3.harga = "Rp31.560.000"
//        p3.gambar = R.drawable.apple
//
//        val p4 = Produk()
//        p4.nama = "JBL Speaker"
//        p4.harga = "Rp.28.900.000"
//        p4.gambar = R.drawable.huawai
//
//
//        arr.add(p1)
//        arr.add(p2)
//        arr.add(p3)
//        arr.add(p4)
//
//        return arr
//    }


}