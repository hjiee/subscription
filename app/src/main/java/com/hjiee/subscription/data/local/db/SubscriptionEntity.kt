package com.hjiee.subscription.data.local.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.hjiee.subscription.data.model.SubscriptionType
import com.hjiee.subscription.ui.AppApplication.Companion.DATABASE_NAME
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "subscription")
data class SubscriptionEntity(
    @PrimaryKey(autoGenerate = true) val id : Int,
    val imageUrl: String? = null,
    val product: String,
    val title: String,
    val price: Float,
    val type: SubscriptionType,
    val isPopular: Boolean,
    val paymentUrl : String? = null
) : Parcelable

fun convertToSubscriptionEntity(documents: Map<*, *>?): SubscriptionEntity? {
    return documents?.run {
        SubscriptionEntity(
            id = 0,
            product = get("product").toString(),
            title = get("title").toString(),
            price = get("price").toString().toFloat(),
            type = convertType(get("type").toString()),
            isPopular = get("isPopular").toString().toBoolean()
        )
    } as SubscriptionEntity
}

fun convertType(type: String) = enumValueOf<SubscriptionType>(type)
