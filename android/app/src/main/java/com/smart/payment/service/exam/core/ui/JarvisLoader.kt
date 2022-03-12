package com.smart.payment.service.exam.core.ui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.LinearLayout
import com.smart.payment.service.exam.R

class JarvisLoader(context: Context):Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_jarvis_loader)

        window?.apply {
            setLayout(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)

            setBackgroundDrawableResource(R.color.white_transparent)
        }
    }
}