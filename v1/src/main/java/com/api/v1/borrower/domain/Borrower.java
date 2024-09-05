package com.api.v1.borrower.domain;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import com.api.v1.borrower.dtos.NewBorrowerRequestDto;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "v1_borrowers")
public class Borrower {

    @Field
    private String firstName;

    @Field
    private String middleName;

    @Field
    private String lastName;

    @Field
    private LocalDate birthDate;

    @Field
    private String ssn;

    @Field
    private String email;

    @Field
    private String address;

    @Field
    private String phoneNumber;

    @Field
    private String gender;

    @Field
    private String createdAt;

    @Field
    private String updatedAt;

    public Borrower() {}

    public Borrower(
            String firstName,
            String middleName,
            String lastName,
            LocalDate birthDate,
            String ssn,
            String email,
            String address,
            String phoneNumber,
            String gender,
            String createdAt
    ) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.ssn = ssn;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.createdAt = createdAt;
    }

    public void update(NewBorrowerRequestDto request) {
        this.firstName = request.firstName();
        this.middleName = request.middleName();
        this.lastName = request.lastName();
        this.birthDate = request.birthDate();
        this.ssn = request.ssn();
        this.email = request.email();
        this.address = request.address();
        this.phoneNumber = request.phoneNumber();
        this.gender = request.gender();
        this.updatedAt = ZonedDateTime.now().toString();
    }

    public String getFullName() {
        if (middleName.isEmpty()) {
            return "%s %s".formatted(firstName, lastName);
        }
        return "%s %s %s".formatted(firstName, middleName, lastName);
    }

    public void inactive() {
        updatedAt = ZonedDateTime.now().toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

}
