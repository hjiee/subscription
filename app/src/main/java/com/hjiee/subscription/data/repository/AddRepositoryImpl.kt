package com.hjiee.subscription.data.repository

import com.hjiee.subscription.data.local.db.SubscriptionDao
import com.hjiee.subscription.data.local.db.SubscriptionEntity
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AddRepositoryImpl @Inject constructor(
    private val subscriptionDao: SubscriptionDao
): AddRepository {

    override fun insert(subscriptionEntity: SubscriptionEntity) : Completable {
        return subscriptionDao.insert(listOf(subscriptionEntity))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun isContains(subscriptionEntity: SubscriptionEntity): Single<SubscriptionEntity?> {
        return subscriptionDao.isContains(subscriptionEntity.title)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}