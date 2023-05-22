package br.com.igorbag.githubapp.data.remote.exceptions

sealed class HttpException(
    message: String? = null,
    cause: Throwable? = null
) : Throwable(message, cause)

class UnexpectedException(message: String?) : HttpException()
