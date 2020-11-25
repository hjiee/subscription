package com.hjiee.subscription.ui.home

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hjiee.base.BaseViewModel
import com.hjiee.subscription.data.local.db.SubscriptionEntity
import com.hjiee.subscription.data.repository.HomeRepository
import com.hjiee.util.SingleLiveEvent
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

    val isDeleted = SingleLiveEvent<Boolean>()

    fun read() {
        homeRepository.read()
            .doOnSubscribe {  }
            .doOnSuccess { isRefresh.value = false }
            .subscribe(
                {
                    var sum = 0f
                    _items.value = it
                    it.map { entity ->
                        sum += entity.price
                    }
                    _total.value = sum
                },
                {

                }
            ).addTo(compositeDisposable)
    }

    fun delete(id : Int) {
        homeRepository.delete(id)
            .subscribe({
                Log.d("error","delete : success")
                isDeleted.call(true) }, { isDeleted.call(false) })
            .addTo(compositeDisposable)
    }

    fun remove(position : Int) {
        Log.d("error","delete : ${_items.value?.get(position)}")
        _items.value?.get(position)?.id?.let {
            delete(it)
        }
        _items.value = _items.value?.let {
            it.toMutableList().run {
                _total.value = _total.value?.minus(get(position).price)
                removeAt(position)
                this
            }
        }
    }
}