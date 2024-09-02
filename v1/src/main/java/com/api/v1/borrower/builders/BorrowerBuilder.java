package com.api.v1.borrower.builders;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.dtos.NewBorrowerRequestDto;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

public class BorrowerBuilder {

    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthDate;
    private String ssn;
    private String email;
    private String address;
    private String phoneNumber;
    private String gender;
    private final String createdAt = ZonedDateTime.now().toString();

    protected BorrowerBuilder() {}

    public static BorrowerBuilder create() {
        return new BorrowerBuilder();
    }

    public BorrowerBuilder fromDto(NewBorrowerRequestDto dto) {
        this.firstName = dto.firstName();
        this.middleName = dto.middleName();
        this.lastName = dto.lastName();
        this.birthDate = dto.birthDate();
        this.ssn = dto.ssn();
        this.email = dto.email();
        this.address = dto.address();
        this.phoneNumber = dto.phoneNumber();
        this.gender = dto.gender();
        return this;
    }

    public Borrower build() {
        return new Borrower(
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
