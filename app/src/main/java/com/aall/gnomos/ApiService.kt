package com.aall.gnomos

import BrastlewarkList
import SerializedBrastlewarkList
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/rrafols/mobile_test/master/data.json")
    fun getGnomos(): Call<SerializedBrastlewarkList>
}