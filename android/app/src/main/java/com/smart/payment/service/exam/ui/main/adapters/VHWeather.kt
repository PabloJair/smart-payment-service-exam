package com.smart.payment.service.exam.ui.main.adapters

import com.smart.payment.service.exam.data.remote.model.Daily
import android.view.ViewGroup
import com.smart.payment.service.exam.core.base.BaseViewHolder
import com.smart.payment.service.exam.core.utils.goTo
import com.smart.payment.service.exam.databinding.ItemWeatherBinding
import java.util.*

class VHWeather (viewGroup: ViewGroup): BaseViewHolder<ItemWeatherBinding, Daily>(
    ItemWeatherBinding.inflate(android.view.LayoutInflater.from(viewGroup.context),viewGroup,false)) {
    override fun setup(item: Daily) {

        binding.day.text = java.text.SimpleDateFormat("dd/MM/yyyy").format( Date(item.dt*1000))
        binding.temp.text = "Max: ${ item.temp.max}- Min: ${item.temp.min}"
        binding.humidity .text = "Humedad: ${item.humidity}"

        binding.rootView.setOnClickListener {

            binding.rootView.context.goTo(item)

        }
    }
}