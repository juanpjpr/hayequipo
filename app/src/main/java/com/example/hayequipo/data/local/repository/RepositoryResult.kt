package com.example.hayequipo.data.local.repository

sealed class RepositoryResult<T>(
    val data: T? = null,
    val errorMessage: String? = null,
) {
    class Success<T>(data: T?) : RepositoryResult<T>(data = data)

    class Error<T>(errorMessage: String, data: T? = null) :
        RepositoryResult<T>(data = data, errorMessage = errorMessage)
}

