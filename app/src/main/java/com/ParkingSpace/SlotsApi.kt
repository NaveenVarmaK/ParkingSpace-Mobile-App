package com.ParkingSpace

import retrofit2.Response
import retrofit2.http.GET

interface SlotsApi {

    @GET("/api/slots")
    suspend fun getSlots(): Response<List<Slots>>
}