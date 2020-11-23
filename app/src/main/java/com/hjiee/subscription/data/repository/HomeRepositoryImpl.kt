package com.hjiee.subscription.data.repository

import com.hjiee.subscription.data.local.db.SubscriptionDao
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val subscriptionDao: SubscriptionDao
) : HomeRepository {
    override fun load() {
        subscriptionDao.getAll()
    }
}