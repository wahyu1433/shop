package com.example.shop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.shop.R
import com.example.shop.helper.Helper
import com.example.shop.model.Produk
import com.example.shop.room.MyDatabase
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_detail_produk.*
import kotlinx.android.synthetic.main.toolbar_custom.*

class DetailProdukActivity : AppCompatActivity() {

    lateinit var myDb: MyDatabase
    lateinit var produk: Produk

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_produk)
        myDb = MyDatabase.getInstance(this)!! // call database

        getInfo()
        mainButton()
        checkkeranjang()
    }

    private fun mainButton(){
        btn_keranjang.setOnClickListener{
            insert()
        }

        btn_favorit.setOnClickListener {
            val listData = myDb.daoKeranjang().getAll() // get All data
            for (note: Produk in listData) {
                println("-----------------------")
                println(note.name)
                println(note.harga)
            }
        }
    }




    private fun insert(){
        val myDb: MyDatabase = MyDatabase.getInstance(this)!! // call database
        val note = Produk() //create new keranjang
        note.name = "First Keranjang"
        note.harga = "10000000"

        CompositeDisposable().add(Observable.fromCallable { myDb.daoKeranjang().insert(note) }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                checkkeranjang()
                Log.d("respons", "data inserted")
            })
    }

    private fun checkkeranjang() {
        val datakeranjang = myDb.daoKeranjang().getAll()

        if(datakeranjang.isNotEmpty()){
            div_angka.visibility = View.VISIBLE
            tv_angka.text = datakeranjang.size.toString()
        }else{
            div_angka.visibility = View.GONE
        }
    }
    private fun getInfo(){
        val data = intent.getStringExtra("extra")
        val produk = Gson().fromJson(data, Produk::class.java)
        //val produk = Gson().fromJson<Produk>(data, Produk::class.java)

        // set Value
        tv_nama.text = produk.name
        tv_harga.text = Helper().gantiRupiah(produk.harga)
        tv_deskripsi.text = produk.deskripsi

        val img = "http://192.168.43.182/shop/public/storage/produk/" + produk.image
        Picasso.get()
            .load(img)
            .placeholder(R.drawable.product)
            .error(R.drawable.product)
            .resize(400, 400)
            .into(image)

        // setToolbar
//        Helper().setToolbar(this, toolbar, produk.name)
    }
}