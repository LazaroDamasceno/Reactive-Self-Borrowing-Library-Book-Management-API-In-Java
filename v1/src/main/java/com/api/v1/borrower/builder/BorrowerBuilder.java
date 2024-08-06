package com.api.v1.borrower.builder;

import com.api.v1.borrower.domain.Borrower;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

public class BorrowerBuilder {

    private final UUID id = UUID.randomUUID();
    private String firstName;
    private String middleName;
    private String lastName;
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

    public BorrowerBuilder withFirstName(String firstName) {
        this.firstName = Objects.requireNonNull(firstName);
        return this;
    }

    public BorrowerBuilder withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public BorrowerBuilder withLastName(String lastName) {
        this.lastName = Objects.requireNonNull(lastName);
        return this;
    }

    public BorrowerBuilder withSsn(String ssn) {
        this.ssn = Objects.requireNonNull(ssn);
        return this;
    }

    public BorrowerBuilder withEmail(String email) {
        this.email = Objects.requireNonNull(email);
        return this;
    }

    public BorrowerBuilder withAddress(String address) {
        this.address = Objects.requireNonNull(address);
        return this;
    }

    public BorrowerBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
        return this;
    }

    public BorrowerBuilder withGender(String gender) {
        this.gender = Objects.requireNonNull(gender);
        return this;
    }

    public Borrower build() {
        return new Borrower(
            this.id,
            this.firstName,
            this.middleName,
            this.lastName,
            this.ssn,
            this.email,
            this.address,
            this.phoneNumber, 
            this.gender,
            this.createdAt
        );
    }    

}
