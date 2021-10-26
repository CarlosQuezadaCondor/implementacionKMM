package com.carlosquezada.retoscotiabank.data.local

import com.carlosquezada.retoscotiabank.domain.Either
import com.carlosquezada.retoscotiabank.domain.Result
import com.carlosquezada.retoscotiabank.domain.model.Movie

interface MoviesLocal {
    fun hasMoviesList(): Boolean
    suspend fun getMovies(): Either<Result.Error, List<Movie>>
    suspend fun saveMovies(movies: List<Movie>): Either<Result.Error, Result.Success>
}