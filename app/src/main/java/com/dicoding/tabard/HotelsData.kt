package com.dicoding.tabard

object HotelsData {
    private val hotelNames = arrayOf(
        "Best Western Premier The Hive",
        "Diradja Hotel",
        "Horison Ciledug",
        "Hotel Orchardz Bandara",
        "Juno Jatinegara Jakarta",
        "Liberta Hotel Kemang",
        "Lumire Hotel & Convention Center",
        "Merlynn Park Hotel",
        "Mercure Jakarta Sabang",
        "Park 5 Simatupang",
        "Sunlake Hotel",
        "Takes Hotel Jakarta, a PHM Collection",
        "The BnB Hotel Kelapa Gading",
        "Whiz Hotel Cikini - Menteng",
        "Zest Hotel Airport Jakarta"
    )

    private val hotelAddress = arrayOf(
        "Jl. DI Panjaitan Kav. 3 - 4, Cawang, Kramat Jati, Jakarta, Indonesia, 13340",
        "JL. Kapt Tendean No.38, Jakarta Selatan, Mampang, Tendean, Jakarta, Indonesia, 12710",
        "Jalan Ciledug Raya, No.17, Pesanggrahan, Petukangan Utara, Jakarta, Indonesia, 12270",
        "Jalan Husein Sastranegara No 8, Cengkareng, Benda, Jakarta, Indonesia, 15125",
        "Jl. Matraman Raya No. 173-175 Balimester - Jatinegara, Jatinegara, Bidaracina, Jakarta, Indonesia, 13310",
        "Jalan Kemang I No.6 Jakarta Selatan, Kemang, Mampang, Jakarta, Indonesia, 12730",
        "Jalan Senen Raya No.135, Senen, Jakarta Pusat, Jakarta, Indonesia, 10410",
        "Jl. K.H.Hasyim Ashari 29-31, Gambir, Petojo Utara, Jakarta, Indonesia, 10130",
        "Jalan Haji Agus Salim No. 11-13, Menteng, Jakarta Pusat, Jakarta, Indonesia, 10110",
        "Jalan Intan RSPP No.C5 Cilandak Barat, Cilandak, Cilandak Barat, Jakarta, Indonesia, 12430",
        "Jl.Danau Permai Raya Blok C1 Sunter, Jakarta Utara, Sunter, Tanjung Priok, Jakarta, Indonesia, 14350",
        "Jl. Taman Kebon Sirih 1 No. 3, Tanah Abang, Jakarta Pusat, Jakarta, Indonesia, 10250",
        "Boulevard Bukit Gading Raya Kelapa Gading Barat, Kelapa Gading, Kelapa Gading Barat, Jakarta, Indonesia, 14240",
        "Jalan Cikini Raya No. 6, Menteng, Cikini, Jakarta, Indonesia, 10330",
        "Jalan Husein Sastra Negara Kav. 1 Lingkar Benda, Cengkareng, Benda, Jakarta, Indonesia, 15125"
    )

    private val hoteTypes = arrayOf(
        "HOTEL",
        "HOTEL",
        "HOTEL",
        "HOTEL",
        "HOTEL",
        "HOTEL",
        "HOTEL",
        "HOTEL",
        "HOTEL",
        "HOTEL",
        "HOTEL",
        "HOTEL",
        "HOTEL",
        "HOTEL",
        "HOTEL"
    )

    private val hotelPrices = arrayOf(
        "550000",
        "430000",
        "443334",
        "505050",
        "350888",
        "374388",
        "600000",
        "658000",
        "925651",
        "415000",
        "648000",
        "285000",
        "312500",
        "260072",
        "360000"
    )

    private val hotelRatings = intArrayOf(
        5,
        3,
        3,
        3,
        3,
        3,
        4,
        5,
        4,
        3,
        4,
        3,
        3,
        2,
        2
    )

    private val hotelPhotos = intArrayOf(
        R.drawable.best_western_premier_the_hive,
        R.drawable.diradja_hotel,
        R.drawable.horison_ciledug,
        R.drawable.hotel_orchardz_bandara,
        R.drawable.juno_jatinegara_jakarta,
        R.drawable.liberta_hotel_kemang,
        R.drawable.lumire_hotel_convention_center,
        R.drawable.mercure_jakarta_sabang,
        R.drawable.merlynn_park_hotel,
        R.drawable.park_5_simatupang,
        R.drawable.sunlake_hotel,
        R.drawable.takes_hotel_jakarta_a_phm_collection,
        R.drawable.the_bnb_hotel_kelapa_gading,
        R.drawable.whiz_hotel_cikini_menteng,
        R.drawable.zest_hotel_airport_jakarta
    )

    val listData:ArrayList<Hotel>
        get() {
            val list = arrayListOf<Hotel>()
            for(postion in hotelNames.indices){
                val hotel = Hotel()
                hotel.name = hotelNames[postion]
                hotel.address = hotelAddress[postion]
                hotel.type = hoteTypes[postion]
                hotel.price = hotelPrices[postion]
                hotel.rating = hotelRatings[postion]
                hotel.photo = hotelPhotos[postion]
                list.add(hotel)
            }
            return  list
        }
}