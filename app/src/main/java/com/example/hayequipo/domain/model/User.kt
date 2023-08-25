package com.example.hayequipo.domain.model

import androidx.room.PrimaryKey

data class User(
    val user: String,
    val email: String,
    val password: String,
    val owner: Boolean
)
