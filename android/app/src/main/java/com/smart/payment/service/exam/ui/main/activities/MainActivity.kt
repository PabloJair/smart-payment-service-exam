package com.smart.payment.service.exam.ui.main.activities

import android.view.LayoutInflater
import androidx.activity.viewModels
import com.smart.payment.service.exam.core.base.BaseActivity
import com.smart.payment.service.exam.core.utils.LoadingUtils
import com.smart.payment.service.exam.data.remote.model.Daily
import com.smart.payment.service.exam.data.remote.model.WeatherModel
import com.smart.payment.service.exam.databinding.MainActivityBinding
import com.smart.payment.service.exam.ui.main.adapters.AdapterWeather
import com.smart.payment.service.exam.ui.main.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity  (override val bindingInflater: (LayoutInflater) -> MainActivityBinding = MainActivityBinding::inflate)
    : BaseActivity<MainActivityBinding>() {

    var adapter= AdapterWeather()
    private val viewModel by viewModels<MainViewModel>()

    override fun setupView() {
        binding.recyclerView.adapter = adapter
        viewModel.getWeather()

    }

    override fun setupViewModel() {
        viewModel.fetchData().observe(this,::onObserverViewModel)
    }

    override fun onSuccess(data: Any) {
        data as WeatherModel
        adapter.setupItems(data.daily as ArrayList<Daily>)
    }

    override fun onFails(message: String) {
        showError(title = "Error en login","Valida tu conexión de internet ","Cerrar",{
            finishAffinity()
        })
    }
    override fun onLoader(data: Boolean) {
        if(data)
            LoadingUtils.showDialog(this,false)
        else
            LoadingUtils.hideDialog()

    }
}