package com.hjiee.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hjiee.util.NetworkStatus

abstract class BaseViewModel : ViewModel() {

    val loading = MutableLiveData<Boolean>()
    val loadingStatus = MutableLiveData<NetworkStatus>()

    init {
        loading.value = (false)
    }

    override fun onCleared() {
        super.onCleared()
        hideLoading()
    }

    fun showLoading() {
        loading.value = (true)
    }

    fun hideLoading() {
        loading.value = (false)
    }
}