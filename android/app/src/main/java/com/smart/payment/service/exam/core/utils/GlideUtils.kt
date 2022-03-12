package com.smart.payment.service.exam.core.utils

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.smart.payment.service.exam.R

object GlideUtils {

    fun loadImage(context: Context, url: String, imageView: ImageView){

        if(url.isBlank()){
            Glide.with(context)
                .load(R.drawable.ic_broken)
                .placeholder(createProgressBar(context))
                .error(R.drawable.ic_broken)
                .into(imageView)
            return
        }
        Glide.with(context)
            .load(url)
            .placeholder(createProgressBar(context))
            .error(R.drawable.ic_broken)
            .into(imageView)
    }

    private fun createProgressBar(context: Context)=CircularProgressDrawable(context).apply {
            setColorSchemeColors(R.color.primaryColor, R.color.primaryDarkColor, R.color.secondaryDarkColor)
            centerRadius = 30f
            strokeWidth = 5f
            start()
    }
}