package com.hjiee.subscription.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hjiee.subscription.data.model.SubscriptionTypeConverter

@Database(entities = [SubscriptionEntity::class], version = 1)
@TypeConverters(SubscriptionTypeConverter::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getSubscriptionDao() : SubscriptionDao
}