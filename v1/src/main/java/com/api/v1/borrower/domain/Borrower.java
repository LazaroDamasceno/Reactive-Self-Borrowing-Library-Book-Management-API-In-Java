package com.api.v1.borrower.domain;

import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "v1_borrowers")
public class Borrower {
    
    @Id
    private UUID id;

    @Field
    private String firstName;

    @Field
    private String middleName;

    @Field
    private String lastName;

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
    private String updateAt;

    protected Borrower() {}

    public Borrower(
            String firstName, 
            String middleName, 
            String lastName, 
            String ssn, 
            String email, 
            String address,
            String phoneNumber, 
            String gender
    ) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.id = UUID.randomUUID();
        this.createdAt = ZonedDateTime.now().toString();
    }

    public String getFullName() {
        return "%s %s %s".formatted(firstName, middleName, lastName);
    }

    public void update(
            String firstName,
            String middleName,
            String lastName,
            String email,
            String address,
            String phoneNumber,
            String gender
    ) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.id = UUID.randomUUID();
        this.updateAt = ZonedDateTime.now().toString();
    }

    public UUID getId() {
        return id;
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

    public String getSsn() {
        return ssn;
    }

    public String getCreatedAt() {
        return createdAt;
    }

}
