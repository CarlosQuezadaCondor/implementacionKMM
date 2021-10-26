package com.carlosquezada.retoscotiabank.data.repository

import com.carlosquezada.retoscotiabank.domain.Either
import com.carlosquezada.retoscotiabank.domain.Result
import com.carlosquezada.retoscotiabank.domain.model.Movie

interface MoviesRepository {
    suspend fun getMovies(force: Boolean = false): Either<Result.Error, List<Movie>>
}