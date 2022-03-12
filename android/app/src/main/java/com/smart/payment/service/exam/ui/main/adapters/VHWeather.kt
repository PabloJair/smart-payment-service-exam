package com.smart.payment.service.exam.ui.main.adapters

import android.view.ViewGroup
import com.smart.payment.service.exam.core.base.BaseViewHolder
import com.smart.payment.service.exam.data.remote.model.Hourly
import com.smart.payment.service.exam.databinding.ItemWeatherBinding

class VHWeather (viewGroup: ViewGroup): BaseViewHolder<ItemWeatherBinding, Hourly>(
    ItemWeatherBinding.inflate(android.view.LayoutInflater.from(viewGroup.context),viewGroup,false)) {
    override fun setup(item: Hourly) {
        binding.temp.text = item.temp.toString()
        binding.humidity .text = item.humidity.toString()

        binding.rootView.setOnClickListener {


        }
    }
}