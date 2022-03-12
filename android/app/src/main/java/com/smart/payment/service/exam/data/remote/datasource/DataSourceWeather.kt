package com.smart.payment.service.exam.data.remote.datasource

import com.smart.payment.service.exam.data.remote.service.WeatherService
import javax.inject.Inject

class DataSourceWeather @Inject constructor(private val service: WeatherService) {
    suspend fun getWeather()= service.getWeather()

}