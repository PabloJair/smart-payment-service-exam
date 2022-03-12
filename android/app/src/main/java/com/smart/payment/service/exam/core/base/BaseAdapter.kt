package com.smart.payment.service.exam.core.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<T, I: BaseViewHolder<*, T>>: RecyclerView.Adapter<I>() {

    var onClickItem:((item: T,view: ViewBinding)->Unit)?=null

    protected var  items: ArrayList<T> = arrayListOf()

    private lateinit var recyclerView: RecyclerView

    fun setupItems(items:ArrayList<T>){
        this.items = items.ifEmpty { arrayListOf() }
        notifyDataSetChanged()
    }

    fun clearItems(){
        items = arrayListOf()
    }

    fun insertNewElement(addElement:T){
        items.add(addElement)
        notifyItemRangeInserted(items.size+1,items.size)
        recyclerView.smoothScrollToPosition(items.size+1)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView= recyclerView;
    }

    override fun getItemCount(): Int = items.size


}