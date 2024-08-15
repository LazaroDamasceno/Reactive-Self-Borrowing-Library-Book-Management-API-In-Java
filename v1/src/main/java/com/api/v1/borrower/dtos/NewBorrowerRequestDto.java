package com.api.v1.borrower.dtos;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

import com.api.v1.annotations.SSN;

public record NewBorrowerRequestDto(
    @NotBlank String firstName,
    String middleName,
    @NotBlank String lastName,
    @NotNull LocalDate birthDate,
    @SSN String ssn,
    @NotNull @Email String email,
    @NotBlank String address,
    @NotNull @Size(min=10, max=10) String phoneNumber,
    @NotNull @Size(min=1) String gender
) {
    
}
