package com.api.v1.book.dtos

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class UpdateBookRequestDto(
    @NotBlank val title: String,
    val subtitle: String,
    @NotBlank val publisher: String,
    @Min(1) val version: Int,
    @Min(1) val numberOfPages: Int,
    @NotBlank val author: String,
    @NotBlank val field: String
)