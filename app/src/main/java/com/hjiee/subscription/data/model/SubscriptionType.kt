package com.hjiee.subscription.data.model

import androidx.room.TypeConverter

enum class SubscriptionType {
    /**
     * 정기결제
     */
    PERIODIC,

    /**
     * 30일권
     */
    ONECE,

    /**
     * 디폴트
     */
    NONE
}

class SubscriptionTypeConverter() {
    @TypeConverter
    fun toSubscription(type : String) = enumValueOf<SubscriptionType>(type)

    @TypeConverter
    fun fromSubscription(type : SubscriptionType) = type.name

}