package com.api.v1.book.helpers

data class BookResponseDto(
    val fullTitle: String,
    val isbn: String,
    val publisher: String,
    val version: Int,
    val numberOfPages: Int,
    val author: String,
    val field: String
)
