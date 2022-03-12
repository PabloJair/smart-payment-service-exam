package com.smart.payment.service.exam.core.network

import com.smart.payment.service.exam.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {


    fun loggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level=         HttpLoggingInterceptor.Level.BODY

        }

    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
    }
    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()


    @Singleton
    @Provides
    @Named("Retrofit")
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl( BuildConfig.URL_BASE_API)
            .client(provideHttpClient())
            .addConverterFactory(provideConverterFactory())
            .build()
    }


}