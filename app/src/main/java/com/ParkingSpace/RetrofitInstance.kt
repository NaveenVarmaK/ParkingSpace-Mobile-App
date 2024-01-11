package com.ParkingSpace

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: SlotsApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://localhost:8084")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SlotsApi::class.java)

    }
}