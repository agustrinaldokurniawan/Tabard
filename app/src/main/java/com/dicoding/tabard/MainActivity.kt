package com.dicoding.tabard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvHotels : RecyclerView
    private var list:ArrayList<Hotel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHotels = findViewById(R.id.rv_hotels)
        rvHotels.setHasFixedSize(true)

        val aboutButton : Button = findViewById(R.id.about_button)
        aboutButton.setOnClickListener(this)

        list.addAll(HotelsData.listData)
        showRecyclesList()
    }

    private fun showRecyclesList() {
        rvHotels.layoutManager = LinearLayoutManager(this)
        val listHotelAdapter = ListHotelAdapter(list)
        rvHotels.adapter = listHotelAdapter

        listHotelAdapter.setOnItemCallback(object : ListHotelAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hotel) {
                showSelectedHotel(data)
            }
        })
    }

    private fun showSelectedHotel(hotel: Hotel){
        val showDetailIntent = Intent(this@MainActivity, ItemDetailHotel::class.java)
        showDetailIntent.putExtra(ItemDetailHotel.EXTRA_HOTEL_NAME, hotel.name)
        showDetailIntent.putExtra(ItemDetailHotel.EXTRA_HOTEL_ADDRESS, hotel.address)
        showDetailIntent.putExtra(ItemDetailHotel.EXTRA_HOTEL_PRICE, hotel.price)
        showDetailIntent.putExtra(ItemDetailHotel.EXTRA_HOTEL_RATING, hotel.rating)
        showDetailIntent.putExtra(ItemDetailHotel.EXTRA_HOTEL_IMAGE, hotel.photo)
        startActivity(showDetailIntent)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.about_button -> {
                val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutIntent)
            }
        }
    }
}