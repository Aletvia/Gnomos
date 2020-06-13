package com.aall.gnomos

import Brastlewark
import SerializedBrastlewarkList
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    /*private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager*/
    private val urlBase = "https://raw.githubusercontent.com"
    private lateinit var service: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder().baseUrl(urlBase)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(ApiService::class.java)
        getAll()
    }
    fun getAll(){
        service.getGnomos().enqueue(object : Callback<SerializedBrastlewarkList>{
            override fun onResponse(call: Call<SerializedBrastlewarkList>?, res: Response<SerializedBrastlewarkList>?){
                Log.i("OnResponse","OK")
                val brastlewark = res?.body()
                Log.i("LISTA", Gson().toJson(brastlewark))

            }
            override fun onFailure(call: Call<SerializedBrastlewarkList>?, t: Throwable?) {
                Log.e("Error","getAll")
                Log.e("ERROR: ","${t?.message}")
                t?.printStackTrace()
            }
        })
    }
}
