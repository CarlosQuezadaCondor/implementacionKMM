package com.carlosquezada.retoscotiabank.data.repository

import com.carlosquezada.retoscotiabank.data.local.MoviesLocal
import com.carlosquezada.retoscotiabank.data.remote.MoviesRemote
import com.carlosquezada.retoscotiabank.domain.Either
import com.carlosquezada.retoscotiabank.domain.Result
import com.carlosquezada.retoscotiabank.domain.model.Movie

class CommonMoviesRepository(
    private val moviesRemote: MoviesRemote,
    private val moviesLocal: MoviesLocal
) : MoviesRepository {


    override suspend fun getMovies(force: Boolean): Either<Result.Error, List<Movie>> {
        return when (force) {
            true -> fetchAndSaveMovies()
            false -> when (moviesLocal.hasMoviesList()) {
                true -> moviesLocal.getMovies()
                false -> fetchAndSaveMovies()
            }
        }
    }

    private suspend fun fetchAndSaveMovies(): Either<Result.Error, List<Movie>> {
        return moviesRemote.getMovies().flatMap { movies ->
            moviesLocal.saveMovies(movies.success)
            movies
        }
    }


}