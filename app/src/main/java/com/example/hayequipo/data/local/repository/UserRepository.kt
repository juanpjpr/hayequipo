package com.example.hayequipo.data.local.repository

import com.example.hayequipo.data.local.daos.UserDao
import com.example.hayequipo.data.local.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao)  {

    suspend fun getUserByUsernameAndPassword(username: String, password: String): RepositoryResult<User> {
        val res = userDao.getUserByUsernameAndPassword(username,password)

        return if (res != null) {
            RepositoryResult.Success(res)
        } else {
            RepositoryResult.Error("Invalid credentials")
        }
    }

    suspend fun insertUser(user: User) {

        return userDao.insertUser(user)
    }
}