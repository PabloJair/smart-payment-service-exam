package com.smart.payment.service.exam.core.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T: ViewBinding,U>(var binding:T): RecyclerView.ViewHolder(binding.root) {
    var onClickItem:((item:U,view:T)->Unit)?=null
    abstract fun setup(item:U);
}
