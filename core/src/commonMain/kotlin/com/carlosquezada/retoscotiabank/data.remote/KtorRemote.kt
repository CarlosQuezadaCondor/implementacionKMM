package com.carlosquezada.retoscotiabank.data.remote

import com.carlosquezada.retoscotiabank.data.model.dto.MoviesResultDto
import com.carlosquezada.retoscotiabank.data.model.dto.toModel
import com.carlosquezada.retoscotiabank.withEither
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

class KtorRemote : MoviesRemote {

    override suspend fun getMovies() = withEither {
        val response = client.get<MoviesResultDto> {
            url {
                encodedPath = "movie/popular"
                parameter("sort_by", "popularity.desc")
            }
        }
        response.results.map { it.toModel() }
    }

}

private val client = HttpClient {
    install(JsonFeature) {
        serializer = KotlinxSerializer()
    }
    defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
            host = BASE_URL
            parameter("api_key", "cdf5ce7f499d164bb134ac64f5f07e16")
        }
    }
}

private const val BASE_URL = "api.themoviedb.org/3"
