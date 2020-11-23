package com.hjiee.subscription.di

import android.content.Context
import androidx.room.Room
import com.hjiee.subscription.data.local.db.AppDataBase
import com.hjiee.subscription.data.local.db.SubscriptionDao
import com.hjiee.subscription.data.repository.HomeRepository
import com.hjiee.subscription.data.repository.HomeRepositoryImpl
import com.hjiee.subscription.ui.AppApplication.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context : Context) : AppDataBase = Room.databaseBuilder(context,AppDataBase::class.java, DATABASE_NAME).build()

    @Provides
    @Singleton
    fun provideSubscriptionDao(appDataBase: AppDataBase) : SubscriptionDao = appDataBase.getSubscriptionDao()

    @Provides
    @Singleton
    fun provideHomRepository(subscriptionDao: SubscriptionDao) : HomeRepository = HomeRepositoryImpl(subscriptionDao)
}