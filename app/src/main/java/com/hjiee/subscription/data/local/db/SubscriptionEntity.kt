package com.hjiee.subscription.data.local.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hjiee.subscription.ui.AppApplication.Companion.DATABASE_NAME
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "subscription")
data class SubscriptionEntity(
    @PrimaryKey(autoGenerate = true) val id : Int,
    val title : String,
    val price : Float
) : Parcelable