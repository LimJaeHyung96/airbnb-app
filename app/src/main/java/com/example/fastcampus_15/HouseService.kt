package com.example.fastcampus_15

import retrofit2.Call
import retrofit2.http.GET

interface HouseService {
    @GET("/v3/00268269-1b54-47f8-82b3-d7a1479bf1ec")
    fun getHouseList() : Call<HouseDto>
}