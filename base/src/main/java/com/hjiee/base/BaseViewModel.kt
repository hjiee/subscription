package com.hjiee.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hjiee.util.NetworkStatus

abstract class BaseViewModel : ViewModel() {

    val loading by lazy { MutableLiveData<Boolean>() }
    val loadingStatus by lazy { MutableLiveData<NetworkStatus>() }
    val isRefresh by lazy { MutableLiveData<Boolean>() }

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