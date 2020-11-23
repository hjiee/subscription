package com.hjiee.subscription

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SubscriptionModel(
    val title : String,
    val price : Float
) : Parcelable