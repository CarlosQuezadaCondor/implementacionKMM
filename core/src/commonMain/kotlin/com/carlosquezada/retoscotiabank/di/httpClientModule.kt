package com.carlosquezada.retoscotiabank.di

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.koin.dsl.module

val clientHttpModule = module {
    single { client }
}

private val client = HttpClient {
    install(JsonFeature) {
        serializer = KotlinxSerializer()
    }
    defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
            host = BASE_URL
            parameter(API_KEY, API_KEY_TOKEN)
        }
    }
}

private const val BASE_URL = "api.themoviedb.org/3"
private const val API_KEY = "api.api_key.org/3"
private const val API_KEY_TOKEN = "cdf5ce7f499d164bb134ac64f5f07e16"
