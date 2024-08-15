package com.api.v1.book.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UpdateBookRequestDto(
    @NotBlank String title,
    String subtitle,
    @NotBlank String author,
    int publishingYear,
    @NotBlank String field,
    @Min(1) int numberOfPages,
    @Min(1) int version
) {
    
}
