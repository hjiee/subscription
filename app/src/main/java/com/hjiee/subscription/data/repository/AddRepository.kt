package com.hjiee.subscription.data.repository

import com.hjiee.subscription.data.local.db.SubscriptionEntity
import io.reactivex.Completable
import io.reactivex.Single

interface AddRepository {
    fun insert(subscriptionEntity: SubscriptionEntity) : Completable
    fun isContains(subscriptionEntity: SubscriptionEntity) : Single<SubscriptionEntity?>
}