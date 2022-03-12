package com.smart.payment.service.exam.data.repository

import com.smart.payment.service.exam.data.remote.service.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object WeatherRepository {
    @Singleton
    @Provides
    fun provideCurrencyService(@Named("Retrofit")  retrofit: Retrofit): WeatherService =
        retrofit.create(WeatherService::class.java)
}