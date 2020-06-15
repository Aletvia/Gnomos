package com.aall.gnomos

import SerializedBrastlewarkList
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity(), AdapterBrastlewarkBasic.Listener {
    private var myAdapter: AdapterBrastlewarkBasic ? = null
    private var myBrastlewarkArrayList: ArrayList<BrastlewarkSerialized>? = null
    private val urlBase = "https://raw.githubusercontent.com"
    private lateinit var service: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)
        connection()
    }

    private fun connection(){
        val cm = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        Log.i("Conexted",isConnected.toString())
        if (!isConnected && (myBrastlewarkArrayList==null)){

            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("UPS")
            builder.setMessage("No tienes conexión a internet, regresa más tarde.")
            builder.setPositiveButton("OK"){dialog, which ->
                finish()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }else{
            supportActionBar!!.hide()
            initRecyclerView()
            getAll()
        }
    }

    private fun initRecyclerView() {
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        list_gnomos.layoutManager = layoutManager
    }


    private fun handleResponse(brastlewarkList: List<BrastlewarkSerialized>) {
        Log.i("Lista",brastlewarkList.toString())
        myBrastlewarkArrayList = ArrayList(brastlewarkList)
        myAdapter = AdapterBrastlewarkBasic(myBrastlewarkArrayList!!, this)
        list_gnomos.adapter = myAdapter
    }

    override fun onItemClick(brast_gnomo: BrastlewarkSerialized) {
        val intent = Intent(this, FullProfile::class.java)
        intent.putExtra("EXTRA_GNOMO", Gson().toJson(brast_gnomo))
        startActivity(intent)
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("onRESTART", "PromoNo: " )
    }
    private fun getAll(){
        val retrofit = Retrofit.Builder().baseUrl(urlBase)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(ApiService::class.java)
        service.getGnomos().enqueue(object : Callback<SerializedBrastlewarkList>{
            override fun onResponse(call: Call<SerializedBrastlewarkList>?, res: Response<SerializedBrastlewarkList>?){
                Log.i("OnResponse","OK")
                val brastlewark = res?.body()
                val brast_json = Gson().toJson(brastlewark)
                val child1 = Gson().fromJson(brast_json, SerializedBrastlewarkList::class.java)
                val _adapterPaymentHistory = child1.brastlewark
                /*for(gnomo in _adapterPaymentHistory){
                    Log.i("Gnomo", gnomo.name)
                }*/
                handleResponse(_adapterPaymentHistory)
            }
            override fun onFailure(call: Call<SerializedBrastlewarkList>?, t: Throwable?) {
                Log.e("Error","getAll")
                Log.e("ERROR: ","${t?.message}")
                t?.printStackTrace()
            }
        })
    }
}
