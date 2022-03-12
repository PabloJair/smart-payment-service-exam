package com.smart.payment.service.exam.ui.splash

import android.annotation.SuppressLint
import android.os.CountDownTimer
import android.view.LayoutInflater
import com.smart.payment.service.exam.core.base.BaseActivity
import com.smart.payment.service.exam.databinding.SplashActivityBinding
import com.smart.payment.service.exam.ui.main.activities.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import com.smart.payment.service.exam.core.utils.startActivity

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity (override val bindingInflater: (LayoutInflater) -> SplashActivityBinding = SplashActivityBinding::inflate)
    : BaseActivity<SplashActivityBinding>() {

    override fun setupView() {
        supportActionBar?.hide();
        object : CountDownTimer(10000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {

                startActivity(MainActivity::class.java)
            }
        }.start()    }
}