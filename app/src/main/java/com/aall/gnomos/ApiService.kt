package com.aall.gnomos

import SerializedBrastlewarkList
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/rrafols/mobile_test/master/data.json")
    fun getGnomos(): Call<SerializedBrastlewarkList>


    @GET("/rrafols/mobile_test/master/data.json")
    fun getData() : Observable<List<BrastlewarkSerialized>>
}