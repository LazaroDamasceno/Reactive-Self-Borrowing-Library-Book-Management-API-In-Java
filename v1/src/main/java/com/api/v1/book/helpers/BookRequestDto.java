package com.api.v1.book.helpers;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

public record BookRequestDto(
        @NotBlank String title,
        String subtitle,
        @NotBlank String author,
        @NotBlank String field,
        @Min(1) int numberOfPages,
        @Min(1) int version
) {
}
