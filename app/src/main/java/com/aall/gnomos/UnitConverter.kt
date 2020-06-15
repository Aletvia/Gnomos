package com.aall.gnomos

import java.text.DecimalFormat

class UnitConverter {

    fun Converter(x:Double, type:String): String{
        var aux : Double
        when(type){
            "cmTOm" -> {
                aux = x / 100
            } "weight" -> {
                aux = x
            } else -> {
                aux =0.0
            }
        }
        return CutNumber(aux)
    }
    fun CutNumber(x : Double): String{
        val dec = DecimalFormat("####.##")
        return dec.format(x)
    }
}