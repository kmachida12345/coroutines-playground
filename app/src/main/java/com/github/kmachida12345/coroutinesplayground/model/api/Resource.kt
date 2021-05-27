package com.github.kmachida12345.coroutinesplayground.model.api

sealed class Resource<out T>(
    val data: T? = null,
    val message: String? = null
) {
    object Loading : Resource<Nothing>()

    class Success<out T>(data: T) : Resource<T>(data)

    class Error(val error: Throwable) : Resource<Nothing>()
}