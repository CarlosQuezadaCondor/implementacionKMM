package com.carlosquezada.retoscotiabank.data.remote

import com.carlosquezada.retoscotiabank.data.model.dto.MoviesResultDto
import com.carlosquezada.retoscotiabank.domain.Either
import com.carlosquezada.retoscotiabank.domain.Result
import com.carlosquezada.retoscotiabank.domain.model.Movie

interface MoviesRemote {
    suspend fun getMovies(): Either<Result.Error, List<Movie>>
}