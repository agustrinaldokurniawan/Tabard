package com.dicoding.tabard

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.awesomedialog.AwesomeDialog
import com.example.awesomedialog.body
import com.example.awesomedialog.onPositive
import com.example.awesomedialog.title

class ItemDetailHotel : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_HOTEL_NAME = "extra_hotel_name"
        const val EXTRA_HOTEL_PRICE = "extra_hotel_price"
        const val EXTRA_HOTEL_ADDRESS = "extra_hotel_address"
        const val EXTRA_HOTEL_RATING = "extra_hotel_rating"
        const val EXTRA_HOTEL_IMAGE = "extra_hotel_image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_detail_hotel)

        val backButton: ImageButton = findViewById(R.id.back_button)
        val shareButton: ImageButton = findViewById(R.id.share_button)

        val bookingButton: Button = findViewById(R.id.booking_button)
        bookingButton.setOnClickListener(this)

        val tvHotelName: TextView = findViewById(R.id.tv_hotel_name_detail)
        val tvHotelAddress: TextView = findViewById(R.id.tv_hotel_address_detail)
        val tvHotelPrice: TextView = findViewById(R.id.tv_hotel_price_detail)
        val rbHotelRating: RatingBar = findViewById(R.id.rb_item_detail)
        val imgHotelDetail: ImageView = findViewById(R.id.img_item_detail)


        val hotelName = intent.getStringExtra(EXTRA_HOTEL_NAME)
        val hotelAddress = intent.getStringExtra(EXTRA_HOTEL_ADDRESS)
        val hotelRating = intent.getIntExtra(EXTRA_HOTEL_RATING, 0)
        val hotelPrice = intent.getStringExtra(EXTRA_HOTEL_PRICE)
        val hotelImage = intent.getIntExtra(EXTRA_HOTEL_IMAGE, 0)

        val priceFormatted = hotelPrice?.toDouble()?.let { rupiah(it) }

        tvHotelName.text = hotelName
        tvHotelAddress.text = hotelAddress
        rbHotelRating.rating = hotelRating.toFloat()
        imgHotelDetail.setImageResource(hotelImage)
        tvHotelPrice.text = getString(R.string.price, priceFormatted)

        backButton.setOnClickListener(this)
        shareButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.back_button -> {
                val listIntent = Intent(this@ItemDetailHotel, MainActivity::class.java)
                startActivity(listIntent)
            }

            R.id.share_button -> {
                val emailIntent = Intent().apply {
                    action = Intent.ACTION_SENDTO
                    type = "plain/text"
                    data=Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_SUBJECT, "Hey, checkout this hotel")
                    putExtra(
                        Intent.EXTRA_TEXT, """
                        ${intent.getStringExtra(EXTRA_HOTEL_NAME)}
                        ${intent.getStringExtra(EXTRA_HOTEL_ADDRESS)}
                        ${intent.getStringExtra(EXTRA_HOTEL_PRICE)?.toDouble()
                            ?.let { rupiah(it) }}/malam
                    """.trimIndent()
                    )
                }

                startActivity(Intent.createChooser(emailIntent, null))
            }
            R.id.booking_button -> {
                AwesomeDialog.build(this)
                    .title("Perbaikan")
                    .body("Maaf, saat ini sedang dilakukan perbaikan pada aplikasi")
                    .onPositive("Kembali") {
                        this.finish()
                    }
            }
        }
    }


}