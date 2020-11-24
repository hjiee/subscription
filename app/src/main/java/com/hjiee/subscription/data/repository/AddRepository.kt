package com.hjiee.subscription.data.repository

import com.hjiee.subscription.data.local.db.SubscriptionEntity
import io.reactivex.Completable

interface AddRepository {
    fun insert(subscriptionEntity: SubscriptionEntity) : Completable
}