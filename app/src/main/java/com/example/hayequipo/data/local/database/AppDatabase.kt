package com.example.hayequipo.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hayequipo.data.local.daos.UserDao
import com.example.hayequipo.data.local.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

}