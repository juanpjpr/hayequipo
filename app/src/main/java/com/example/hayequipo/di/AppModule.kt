package com.example.hayequipo.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.hayequipo.data.local.daos.UserDao
import com.example.hayequipo.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            AppDatabase::class.java,
            "canchitas_db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }

}