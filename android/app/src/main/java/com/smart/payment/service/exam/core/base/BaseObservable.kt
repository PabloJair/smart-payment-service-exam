package com.smart.payment.service.exam.core.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.smart.payment.service.exam.core.network.NetworkResult

abstract class BaseObservable(application: Application): AndroidViewModel(application) {


     private var loader        = MutableLiveData<Boolean>()
     private var success       = MutableLiveData<Any>()
     private var error         = MutableLiveData<String>()

     open fun fetchData(): MediatorLiveData<BaseFetchData> {
          val mediator = MediatorLiveData<BaseFetchData>()

          mediator.addSource(loader) {
               if (it != null)
                    mediator.value = BaseFetchData.Loader(it)
          }

          mediator.addSource(success) {
               if (it != null)
                    mediator.value = BaseFetchData.Success(it)
          }

          mediator.addSource(error) {

               if (it != null)
                    mediator.value = BaseFetchData.Error(it)

          }
          return mediator
     }


     fun <T> setupLiveData(networkResult: NetworkResult<T>){
          when(networkResult){
               is NetworkResult.Success->this.success.value = networkResult.data
               is NetworkResult.Error->this.error.value = networkResult.message
               is NetworkResult.Loading->this.loader.value = networkResult.isLoading

          }

     }

}