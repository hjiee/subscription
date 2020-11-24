package com.hjiee.subscription.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hjiee.base.BaseViewModel
import com.hjiee.subscription.data.local.db.SubscriptionEntity
import com.hjiee.subscription.data.repository.HomeRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class HomeViewModel @ViewModelInject constructor(
    private val homeRepository: HomeRepository
) : BaseViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _items = MutableLiveData<List<SubscriptionEntity>>()
    val items : LiveData<List<SubscriptionEntity>> get() = _items

    private val _total = MutableLiveData(0f)
    val total : LiveData<Float> get() = _total

    fun read() {
        _total.value = 0f
        homeRepository.read()
            .subscribe(
                {
                    _items.value = it
                    it.map { entity ->
                        _total.value = (_total.value ?:0f) + entity.price
                    }
                },
                {

                }
            ).addTo(compositeDisposable)
    }
}