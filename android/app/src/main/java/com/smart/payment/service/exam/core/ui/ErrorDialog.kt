package com.smart.payment.service.exam.core.ui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.RawRes

import com.smart.payment.service.exam.R
import com.smart.payment.service.exam.databinding.FragmentDialogBinding

class ErrorDialog(context: Context,
                  val title:String,
                  val subTitle:String,
                  val textBtn1:String="Aceptar",
                  val onClickBtn1:(()->Unit)?=null,
                  @RawRes var lottieFile:Int= R.raw.success,

                  ):Dialog(context) {

    val binding: FragmentDialogBinding = FragmentDialogBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.apply {
            btn1.text = textBtn1
            btn2.visibility = View.GONE
            titleDialog.text = title
            messageDialog.text = subTitle

            btn1.setOnClickListener {
                onClickBtn1?.invoke()
                dismiss()
            }
            iconLottie.setAnimation(lottieFile)

        }

        window?.apply {
            setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)

            setBackgroundDrawableResource(android.R.color.white)
        }
    }
}