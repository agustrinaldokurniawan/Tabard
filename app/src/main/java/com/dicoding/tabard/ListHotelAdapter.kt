package com.dicoding.tabard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class ListHotelAdapter(private  val listHotel:ArrayList<Hotel>):RecyclerView.Adapter<ListHotelAdapter.ListViewHolder>() {
    private  lateinit var onItemClickCallback:OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data:Hotel)
    }

    fun setOnItemCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }


    inner class ListViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        var tvPrice : TextView = itemView.findViewById(R.id.tv_item_price)
        var rbItem : RatingBar = itemView.findViewById(R.id.rb_item)
        var imgPhoto : ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hotels, parent, false)
        return  ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHotel.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hotel = listHotel[position]

        Glide.with(holder.itemView.context)
            .load(hotel.photo)
            .apply(RequestOptions().override(100, 180))
            .into(holder.imgPhoto)

        holder.tvName.text = hotel.name
        holder.rbItem.rating = hotel.rating.toFloat()
        holder.tvPrice.text = "${rupiah(hotel.price.toDouble())}/malam"

        holder.itemView.setOnClickListener{onItemClickCallback.onItemClicked(listHotel[holder.adapterPosition])}
    }

}

fun rupiah(number: Double):String {
    val localeID = Locale("in", "ID")
    val numberFormat = NumberFormat.getCurrencyInstance(localeID)
    return numberFormat.format(number).toString()
}