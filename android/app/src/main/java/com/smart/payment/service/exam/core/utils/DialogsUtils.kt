package com.smart.payment.service.exam.core.utils

import android.content.Context
import androidx.annotation.RawRes
import com.smart.payment.service.exam.R
import com.smart.payment.service.exam.core.ui.ErrorDialog
import com.smart.payment.service.exam.core.ui.SuccessDialog

open class DialogsUtils {

    companion object {
        private var successDialog: SuccessDialog? = null
        private var errorDialog: ErrorDialog? = null

        fun showSuccessDialog(
            context: Context?,
            isCancelable: Boolean,
            title: String,
            subTitle: String,
            textBtn1: String = "Cancelar",
            textBtn2: String = "OK",
            onClickBtn1: (() -> Unit)? = null,
            onClickBtn2: (() -> Unit)? = null,
            @RawRes lottieFile: Int = R.raw.success,
        ) {
            hideSuccessDialog()
            if (context != null) {
                try {
                    successDialog = SuccessDialog(
                        context, title,
                        subTitle,
                        textBtn1,
                        textBtn2,
                        onClickBtn1,
                        onClickBtn2,
                        lottieFile
                    )
                    successDialog?.let { jarvisLoader ->
                        jarvisLoader.setCanceledOnTouchOutside(true)
                        jarvisLoader.setCancelable(isCancelable)
                        jarvisLoader.show()
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        fun hideSuccessDialog() {
            if (successDialog != null && successDialog?.isShowing!!) {
                successDialog = try {
                    successDialog?.dismiss()
                    null
                } catch (e: Exception) {
                    null
                }
            }
        }


        fun showErrorDialog(
            context: Context?,
            isCancelable: Boolean,
            title: String,
            subTitle: String,
            textBtn1: String = "Cancelar",
            onClickBtn1: (() -> Unit)? = null,
            @RawRes lottieFile: Int = R.raw.success,
        ) {
            hideErrorDialog()
            if (context != null) {
                try {
                    errorDialog = ErrorDialog(
                        context, title,
                        subTitle,
                        textBtn1,
                        onClickBtn1,
                        lottieFile
                    )
                    errorDialog?.let { jarvisLoader ->
                        jarvisLoader.setCanceledOnTouchOutside(true)
                        jarvisLoader.setCancelable(isCancelable)
                        jarvisLoader.show()
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        fun hideErrorDialog() {
            if (errorDialog != null && errorDialog?.isShowing!!) {
                errorDialog = try {
                    errorDialog?.dismiss()
                    null
                } catch (e: Exception) {
                    null
                }
            }
        }

    }






}