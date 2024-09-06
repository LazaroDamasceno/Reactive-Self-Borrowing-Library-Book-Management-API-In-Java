package com.api.v1.borrower.dtos;

import java.time.LocalDate;

public record BorrowerResponseDto(
        String fullName,
        LocalDate birthDate,
        String ssn,
        String email,
        String address,
        String phoneNumber,
        String gender,
        String createdAt,
        String updatedAt
) {
}
