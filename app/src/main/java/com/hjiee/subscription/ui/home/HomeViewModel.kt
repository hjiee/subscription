package com.hjiee.subscription.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import com.hjiee.base.BaseViewModel
import com.hjiee.subscription.data.repository.HomeRepository

class HomeViewModel @ViewModelInject constructor(
    private val homeRepository: HomeRepository
) : BaseViewModel() {

    fun load() {
        
    }
}