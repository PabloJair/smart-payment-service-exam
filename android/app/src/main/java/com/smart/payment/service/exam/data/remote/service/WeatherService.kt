package com.smart.payment.service.exam.data.remote.service

import com.smart.payment.service.exam.data.remote.model.WeatherModel
import com.smart.payment.service.exam.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET(EndPoints.GET_ALL_WEATHER)
    suspend fun getWeather(
        @Query("lat") lat:String="23.294122",
        @Query("lon") lon:String="-111.6386056",
        @Query("exclude") type:String="1646697480",
        @Query("appid")appid:String=BuildConfig.API_KEY

        ):
            Response<WeatherModel>
}