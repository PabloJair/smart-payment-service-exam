package com.smart.payment.service.exam.core.utils

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.smart.payment.service.exam.data.remote.model.Daily
import com.smart.payment.service.exam.ui.main.activities.WeatherDetail
import kotlin.math.round

fun<T> AppCompatActivity.startActivity(clazz: Class<T>, finish:Boolean=false){

    Intent(this, clazz).let(::startActivity)
    if(finish) finish()

}

fun Context.goTo(daily: Daily)=
    Intent(this,WeatherDetail::class.java).apply {
        putExtra("weather", Gson().toJson(daily))
    }.let(::startActivity)

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}