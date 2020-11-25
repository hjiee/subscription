package com.hjiee.subscription.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.hjiee.subscription.ui.AppApplication.Companion.DATABASE_LIMIT
import com.hjiee.subscription.ui.AppApplication.Companion.DATABASE_NAME
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface SubscriptionDao {

    @Insert
    fun insert(entity: List<SubscriptionEntity>): Completable

    @Query("SELECT * FROM $DATABASE_NAME WHERE title = :title")
    fun isContains(title : String) : Single<SubscriptionEntity>

    @Query("DELETE FROM $DATABASE_NAME WHERE id = :id")
    fun delete(id: Int): Completable

    @Query("SELECT * FROM $DATABASE_NAME WHERE id = :id")
    fun getSubscription(id: String): SubscriptionEntity

    @Query("SELECT * FROM $DATABASE_NAME LIMIT $DATABASE_LIMIT")
    fun getAll(): Single<List<SubscriptionEntity>>

    @Update
    fun updateSubscription(entity: SubscriptionEntity) : Completable

}