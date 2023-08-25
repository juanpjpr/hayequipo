package com.example.hayequipo.domain.usecases

import com.example.hayequipo.data.local.repository.UserRepository
import com.example.hayequipo.domain.model.User

import javax.inject.Inject

interface CreateUseCase{
    suspend fun createUser(user: User)
}

class CreateNewUserUseCase @Inject constructor(private val userRepository: UserRepository) : CreateUseCase {
    override suspend fun createUser(user: User) {
        val us=com.example.hayequipo.data.local.model.User(
            user = user.user,
            email = user.email,
            password = user.password,
            owner = user.owner)

        val loginResult = userRepository.insertUser(us)

    }
}