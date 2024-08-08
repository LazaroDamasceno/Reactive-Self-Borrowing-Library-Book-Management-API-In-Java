package com.api.v1.borrower.domain

import com.api.v1.borrower.helpers.UpdateBorrowerRequestDto
import lombok.Getter
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.*

@Document(collection = "v1_borrowers")
class Borrower {

    @Id
    var id: UUID
    var firstName: String
    var middleName: String
    var lastName: String
    var ssn: String
    var birthDate: LocalDate
    var email: String
    var address: String
    var gender: String
    var phoneNumber: String
    var createdAt: String
    var updatedAt: String = ""

    constructor(
        id: UUID,
        firstName: String,
        middleName: String,
        lastName: String,
        ssn: String,
        birthDate: LocalDate,
        email: String,
        address: String,
        gender: String,
        phoneNumber: String,
        createdAt: String,
    ) {
        this.id = id
        this.firstName = firstName
        this.middleName = middleName
        this.lastName = lastName
        this.ssn = ssn
        this.birthDate = birthDate
        this.email = email
        this.address = address
        this.gender = gender
        this.phoneNumber = phoneNumber
        this.createdAt = createdAt
    }

    fun getFullName(): String {
        if (middleName.isEmpty()) return "$firstName $lastName"
        return "$firstName $middleName $lastName"
    }

    fun update(request: UpdateBorrowerRequestDto) {
        this.firstName = request.firstName
        this.middleName = request.middleName
        this.lastName = request.lastName
        this.birthDate = request.birthDate
        this.email = request.email
        this.address = request.address
        this.gender = request.gender
        this.phoneNumber = request.phoneNumber
        this.updatedAt = ZonedDateTime.now().toString()
    }

}