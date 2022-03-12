package com.smart.payment.service.exam.core.base
import com.google.gson.annotations.SerializedName


 open class BaseModel<T>(
    @SerializedName("data")
    val data: T?=null,
    @SerializedName("errorCode")
    val errorCode: String?="",
    @SerializedName("errorDetail")
    val errorDetail: String?="",
    @SerializedName("message")
    val message: String?="",
    @SerializedName("status")
    val status: Int?=-1,
    @SerializedName("timestamp")
    val timestamp: String?="",
    @SerializedName("token")
    val token: String?=""
)
