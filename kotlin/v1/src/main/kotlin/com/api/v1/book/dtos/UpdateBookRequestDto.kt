package com.api.v1.book.dtos

import jakarta.validation.constraints.*

data class UpdateBookRequestDto(
    @NotBlank val title: String,
    val subtitle: String,
    @NotBlank val publisher: String,
    @NotEmpty val publishingYear: Int,
    @Min(1) val version: Int,
    @NotEmpty val numberOfPages: Int,
    @NotBlank val author: String,
    @NotBlank val field: String
)