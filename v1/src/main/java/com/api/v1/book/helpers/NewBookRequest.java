package com.api.v1.book.helpers;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewBookRequest(
        @NotBlank String title,
        String subtitle,
        @NotNull @Size(min=13, max=13) String isbn,
        @NotBlank String author,
        @NotBlank String field,
        @NotBlank int numberOfPages,
        @NotBlank int version,
        @NotBlank String description
) {
}
