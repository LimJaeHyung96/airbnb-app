package com.example.fastcampus_15

import retrofit2.Call
import retrofit2.http.GET

interface HouseService {
    @GET("/v3/b3586bba-b65f-442c-8e90-416a872ebae7")
    fun getHouseList() : Call<HouseDto>
}