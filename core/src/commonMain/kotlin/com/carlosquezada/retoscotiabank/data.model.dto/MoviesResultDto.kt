package com.carlosquezada.retoscotiabank.data.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class MoviesResultDto(
    val page: Int,
    val results: List<MovieDto>,
    val total_pages: Int,
    val total_results: Int
)