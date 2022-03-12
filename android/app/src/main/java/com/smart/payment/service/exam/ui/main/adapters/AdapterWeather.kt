package com.smart.payment.service.exam.ui.main.adapters

import android.view.ViewGroup
import com.smart.payment.service.exam.core.base.BaseAdapter
import com.smart.payment.service.exam.core.base.BaseViewHolder
import com.smart.payment.service.exam.data.remote.model.Hourly
import com.smart.payment.service.exam.databinding.ItemWeatherBinding

class AdapterWeather: BaseAdapter<Hourly, BaseViewHolder<ItemWeatherBinding, Hourly>>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ItemWeatherBinding, Hourly> {
        return  VHWeather(parent)

    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemWeatherBinding, Hourly>,
        position: Int
    ) {
        holder.setup(items[position])

    }

}