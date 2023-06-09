package br.com.igorbag.githubapp.data.remote.extensions

import br.com.igorbag.githubapp.data.remote.exceptions.UnexpectedException
import retrofit2.HttpException as RetrofitHttpException

internal fun <T> Result<T>.getOrThrow(): T = getOrElse { throwable ->
    throw throwable.toDomainError()
}

internal fun Throwable.toDomainError(): Throwable {
    return when (this) {
        is RetrofitHttpException -> {
            when (code()) {
                else -> UnexpectedException(message())
            }
        }
        else -> this
    }
}
