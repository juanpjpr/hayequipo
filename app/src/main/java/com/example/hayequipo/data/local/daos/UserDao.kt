package com.example.hayequipo.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.hayequipo.data.local.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    suspend fun getUsers(): List<User>

    @Query("SELECT * FROM users WHERE user = :username AND password = :password")
    suspend fun getUserByUsernameAndPassword(username: String, password: String): User

    @Insert
    suspend fun insertUser(user: User)

}