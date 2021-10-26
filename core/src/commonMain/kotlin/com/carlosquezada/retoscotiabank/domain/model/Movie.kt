package com.carlosquezada.retoscotiabank.domain.model

import com.carlosquezada.core.MovieEntity

data class Movie(
    val adult: Boolean,
    val backdrop_path: String,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

fun Movie.toEntity() = MovieEntity(
    adult = adult,
    backdropPath = backdrop_path,
    id = id,
    originalLanguage = original_language,
    originalTitle = original_title,
    overview = overview,
    popularity = popularity,
    posterPath = poster_path,
    releaseDate = release_date,
    title = title,
    isVideo = video,
    voteAverage = vote_average,
    voteCount = vote_count,
    hasDetails = false,
    isPopular = false,
    isTopRated = false,
    isUpComing = false,
    onStore = false
)

fun MovieEntity.toModel() = Movie(
    adult = adult,
    backdrop_path = backdropPath,
    id = id,
    original_language = originalLanguage,
    original_title = originalTitle,
    overview = overview,
    popularity = popularity,
    poster_path = posterPath,
    release_date = releaseDate,
    title = title,
    video = isVideo,
    vote_average = voteAverage,
    vote_count = voteCount
)