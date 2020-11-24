package com.hjiee.subscription.data.repository

import com.hjiee.subscription.data.local.db.SubscriptionEntity
import io.reactivex.Single

interface HomeRepository {
    fun read() : Single<List<SubscriptionEntity>>
}