package com.smart.payment.service.exam.ui.main.viewmodels

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.smart.payment.service.exam.core.base.BaseObservable
import com.smart.payment.service.exam.data.remote.datasource.RepositoryWeather
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val weatherRepository: RepositoryWeather,
    application: Application

    ) : BaseObservable(application) {

    fun getWeather()=viewModelScope.launch {

        weatherRepository.getWeather().collect {

            setupLiveData(it)
        }
    }
}