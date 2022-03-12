package com.smart.payment.service.exam.data.remote.datasource

import com.smart.payment.service.exam.core.base.BaseApiResponse
import com.smart.payment.service.exam.core.network.NetworkResult
import com.smart.payment.service.exam.data.remote.model.WeatherModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryWeather @Inject constructor(
    private val remote: DataSourceWeather
): BaseApiResponse()  {

    suspend fun getWeather(): Flow<NetworkResult<WeatherModel>> =
        flow {
            emit(NetworkResult.Loading(true))
            emit(safeApiCall { remote.getWeather() })
            delay(2000)
            emit(NetworkResult.Loading(false))
        }.flowOn(Dispatchers.IO)

}