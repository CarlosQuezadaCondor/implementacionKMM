package com.carlosquezada.retoscotiabank.data.local

import com.carlosquezada.core.movies
import com.carlosquezada.retoscotiabank.domain.Result
import com.carlosquezada.retoscotiabank.domain.model.Movie
import com.carlosquezada.retoscotiabank.domain.model.toEntity
import com.carlosquezada.retoscotiabank.domain.model.toModel
import com.carlosquezada.retoscotiabank.withEither
import com.squareup.sqldelight.db.SqlDriver

expect class DbDriver {
    fun get(): SqlDriver
}

class SqlDeligthLocal(dbDriver: DbDriver) : MoviesLocal {

    private val db by lazy { movies(dbDriver.get()) }

    override fun hasMoviesList() = db.moviesQueries.selectAll().executeAsList().isNotEmpty()


    override suspend fun getMovies() = withEither {
        db.moviesQueries.selectAll().executeAsList().map { it.toModel() }
    }

    override suspend fun saveMovies(movies: List<Movie>) = withEither {
        db.moviesQueries.transaction {
            movies.forEach {
                db.moviesQueries.addOrUpdate(it.toEntity())
            }
        }
        Result.Success
    }

}