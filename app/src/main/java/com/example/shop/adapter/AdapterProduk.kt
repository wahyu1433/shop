package com.example.shop.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.R
import com.example.shop.activity.DetailProdukActivity
import com.example.shop.helper.Helper
import com.example.shop.model.Produk
import com.example.shop.util.Config
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class AdapterProduk(var activity: Activity, var data: ArrayList<Produk>):RecyclerView.Adapter<AdapterProduk.Holder>() {

    class Holder(view: View):RecyclerView.ViewHolder(view){

        val tvNama = view.findViewById<TextView>(R.id.tv_nama_produk)
        val tvHarga = view.findViewById<TextView>(R.id.tv_harga)
        val imgGambar = view.findViewById<ImageView>(R.id.img_produk)
        val layout = view.findViewById<CardView>(R.id.layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvNama.text = data[position].name.toString()
        holder.tvHarga.text = Helper().gantiRupiah(data[position].harga)
//        holder.imgGambar.setImageResource(data[position].image)
        val image = Config.productUrl + data[position].image
        Picasso.get()
            .load(image)
            .placeholder(R.drawable.product)
            .error(R.drawable.product)
            .into(holder.imgGambar)


    holder.layout.setOnClickListener {
        val activiti = Intent(activity, DetailProdukActivity::class.java)
        val str = Gson().toJson(data[position], Produk::class.java)
        activiti.putExtra("extra", str)
        activity.startActivity(activiti)
    }
}
    override fun getItemCount(): Int {
        return data.size
    }

}