package com.smart.payment.service.exam.ui.main.adapters

import com.smart.payment.service.exam.data.remote.model.Daily
import android.view.ViewGroup
import com.smart.payment.service.exam.core.base.BaseAdapter
import com.smart.payment.service.exam.core.base.BaseViewHolder
import com.smart.payment.service.exam.databinding.ItemWeatherBinding

class AdapterWeather: BaseAdapter<Daily, BaseViewHolder<ItemWeatherBinding, Daily>>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ItemWeatherBinding, Daily> {
        return  VHWeather(parent)

    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemWeatherBinding, Daily>,
        position: Int
    ) {
        holder.setup(items[position])

    }

}