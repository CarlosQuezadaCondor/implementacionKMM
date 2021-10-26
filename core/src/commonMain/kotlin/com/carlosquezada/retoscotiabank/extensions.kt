package com.carlosquezada.retoscotiabank

import com.carlosquezada.retoscotiabank.domain.Either
import com.carlosquezada.retoscotiabank.domain.Result

suspend fun <T> withEither(block: suspend () -> T): Either<Result.Error, T> = try {
    Either.Right(block())
} catch (e: Exception) {
    Either.Left(Result.Error.Default)
}
