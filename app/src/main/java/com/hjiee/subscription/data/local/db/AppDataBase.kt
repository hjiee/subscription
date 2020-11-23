package com.hjiee.subscription.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SubscriptionEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getSubscriptionDao() : SubscriptionDao
}