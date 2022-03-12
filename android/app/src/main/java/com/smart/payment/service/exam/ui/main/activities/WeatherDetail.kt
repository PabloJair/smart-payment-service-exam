package com.smart.payment.service.exam.ui.main.activities

import android.annotation.SuppressLint
import android.view.LayoutInflater
import com.google.gson.Gson
import com.smart.payment.service.exam.core.base.BaseActivity
import com.smart.payment.service.exam.core.utils.GlideUtils
import com.smart.payment.service.exam.core.utils.round
import com.smart.payment.service.exam.data.remote.model.Daily
import com.smart.payment.service.exam.databinding.MainActivityBinding
import com.smart.payment.service.exam.databinding.WatherDatailsActivityBinding
import java.util.*
import kotlin.math.roundToInt

class WeatherDetail(override val bindingInflater: (LayoutInflater) -> WatherDatailsActivityBinding = WatherDatailsActivityBinding::inflate)
: BaseActivity<WatherDatailsActivityBinding>()  {

    @SuppressLint("SetTextI18n")
    override fun setupView() {
        supportActionBar?.hide();

        val json = intent?.getStringExtra("weather")!!
        var daily = Gson().fromJson(json, Daily::class.java)

        binding.apply {
            updatedAt.text = java.text.SimpleDateFormat("dd/MM/yyyy").format( Date(daily.dt*1000))

            status.text = daily.weather[0].description?:"Sin información"
            temp.text = "${(((daily.temp.max+daily.temp.max) /2) -273.15).round(2)}ºC"
            tempMin.text = "${(daily.temp.min -273.15).round(2)}ºC"
            tempMax.text = "${(daily.temp.max -273.15).round(2)}ºC"

            sunset.text = java.text.SimpleDateFormat("dd/MM/yyyy").format( Date(daily.sunset*1000))
            sunrise.text = java.text.SimpleDateFormat("dd/MM/yyyy").format( Date(daily.sunrise*1000))
            wind.text = daily.windSpeed.toString()
            wind.text = daily.windSpeed.toString()
            pressure.text = daily.pressure.toString()
            pressure.text = daily.pressure.toString()
            humidity.text = daily.humidity.toString()

            GlideUtils.loadImage(this@WeatherDetail,"http://openweathermap.org/img/wn/${daily.weather.firstOrNull()?.icon}@2x.png",icon)
        }
    }

}