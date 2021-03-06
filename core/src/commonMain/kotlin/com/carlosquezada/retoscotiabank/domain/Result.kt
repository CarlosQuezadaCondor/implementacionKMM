package com.carlosquezada.retoscotiabank.domain

sealed class Result {
    sealed class Error: Result() {
        object Default: Error()
        object NotFound: Error()
    }

    object Success: Result()
}