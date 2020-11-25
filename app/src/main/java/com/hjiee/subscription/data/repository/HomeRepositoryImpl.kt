package com.hjiee.subscription.data.repository

import com.hjiee.subscription.data.local.db.SubscriptionDao
import com.hjiee.subscription.data.local.db.SubscriptionEntity
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val subscriptionDao: SubscriptionDao
) : HomeRepository {
    override fun read(): Single<List<SubscriptionEntity>> {
        return subscriptionDao.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun delete(id : Int): Completable {
        return subscriptionDao.delete(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}