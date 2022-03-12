package com.smart.payment.service.exam.core.utils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

fun<T> AppCompatActivity.startActivity(clazz: Class<T>, finish:Boolean=false){

    Intent(this, clazz).let(::startActivity)
    if(finish) finish()

}