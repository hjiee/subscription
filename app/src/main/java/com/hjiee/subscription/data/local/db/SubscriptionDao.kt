package com.hjiee.subscription.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.hjiee.subscription.ui.AppApplication.Companion.DATABASE_LIMIT
import com.hjiee.subscription.ui.AppApplication.Companion.DATABASE_NAME
import io.reactivex.Completable

@Dao
interface SubscriptionDao {

    @Insert
    fun insertSubscription(entity: List<SubscriptionEntity?>): Completable

    @Query("DELETE FROM $DATABASE_NAME WHERE id = :id")
    fun deleteSubscription(id: String): Completable

    @Query("SELECT * FROM $DATABASE_NAME WHERE id = :id")
    fun getSubscription(id: String): SubscriptionEntity

    @Query("SELECT * FROM $DATABASE_NAME LIMIT $DATABASE_LIMIT")
    fun getAll(): List<SubscriptionEntity>

    @Update
    fun updateSubscription(entity: SubscriptionEntity) : Completable

}