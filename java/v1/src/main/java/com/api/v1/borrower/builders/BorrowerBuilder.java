package com.api.v1.borrower.builders;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.dtos.NewBorrowerRequestDto;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

public class BorrowerBuilder {

    private final UUID id = UUID.randomUUID();
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final LocalDate birthDate;
    private final String ssn;
    private final String email;
    private final String address;
    private final String phoneNumber;
    private final String gender;
    private final String createdAt = ZonedDateTime.now().toString();

    public BorrowerBuilder(NewBorrowerRequestDto dto) {
        this.firstName = dto.firstName();
        this.middleName = dto.middleName();
        this.lastName = dto.lastName();
        this.birthDate = dto.birthDate();
        this.ssn = dto.ssn();
        this.email = dto.email();
        this.address = dto.address();
        this.phoneNumber = dto.phoneNumber();
        this.gender = dto.gender();
    }

    public static BorrowerBuilder fromDto(NewBorrowerRequestDto dto) {
        return new BorrowerBuilder(dto);
    } 

    public Borrower build() {
        return new Borrower(
            this.id,
            this.firstName,
            this.middleName,
            this.lastName,
            this.birthDate,
            this.ssn,
            this.email,
            this.address,
            this.phoneNumber, 
            this.gender,
            this.createdAt
        );
    }    

}
