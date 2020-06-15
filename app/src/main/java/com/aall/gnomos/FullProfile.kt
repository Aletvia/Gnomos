package com.aall.gnomos

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.google.gson.Gson
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


class FullProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_profile)
        val gnomo_ext = intent.getSerializableExtra("EXTRA_GNOMO")
        val gnomo = Gson().fromJson(gnomo_ext.toString(), BrastlewarkSerialized::class.java)
        Log.i("extra", gnomo.name)
        fillProfile(gnomo!!)

    }
    fun fillProfile(gnomo : BrastlewarkSerialized){
        val convert = UnitConverter()
        var prof = ""
        var frie = ""
        val txtName: TextView = findViewById<TextView>(R.id.txt_name)
        txtName.text = gnomo.name
        val txtAge: TextView = findViewById<TextView>(R.id.txt_age)
        txtAge.text = gnomo.age.toString()
        val txtWeight: TextView = findViewById<TextView>(R.id.txt_weight)
        txtWeight.text = convert.Converter(gnomo.weight,"weight")
        val txtHeight: TextView = findViewById<TextView>(R.id.txt_height)
        txtHeight.text = convert.Converter(gnomo.height,"cmTOm")
        val txtHair: TextView = findViewById<TextView>(R.id.txt_hair)
        txtHair.text = gnomo.hair_color
        val listProfessions : TextView = findViewById<TextView>(R.id.list_professions)
        gnomo.professions.forEach {
            when(it){
                gnomo.professions.first()->{
                    prof = prof+it
                }else -> {
                    prof = prof+"\n"+it
                }
            }
        }
        listProfessions.text = prof
        val listFriendships : TextView = findViewById<TextView>(R.id.list_friendships)
        gnomo.professions.forEach {
            when(it){
                gnomo.professions.first()->{
                    frie = frie+it
                }else -> {
                frie = frie+"\n"+it
            }
            }
        }
        listFriendships.text = frie


    }

}