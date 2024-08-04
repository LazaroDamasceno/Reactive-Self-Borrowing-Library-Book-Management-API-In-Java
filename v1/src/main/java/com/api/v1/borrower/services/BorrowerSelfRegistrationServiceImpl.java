package com.api.v1.borrower.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.borrower.builder.BorrowerBuilder;
import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.dtos.BorrowerRequest;
import com.api.v1.borrower.dtos.BorrowerResponse;
import com.api.v1.borrower.exceptions.DuplicatedSsnException;
import com.api.v1.borrower.mapper.BorrowerMapper;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import reactor.core.publisher.Mono;

@Service
public class BorrowerSelfRegistrationServiceImpl implements BorrowerSelfRegistrationService {

    @Autowired
    private BorrowerRepository repository;

    @Override
    public Mono<BorrowerResponse> selfRegister(@Valid BorrowerRequest request) {
        String ssn = request.ssn();
        checkIfBorrowerExists(ssn);
        Borrower borrower = new BorrowerBuilder()
                .withFirstName(request.firstName())
                .withMiddleName(request.middleName())
                .withLastName(request.lastName())
                .withSsn(request.ssn())
                .withEmail(request.email())
                .withAddress(request.address())
                .withPhoneNumber(request.phoneNumber())
                .withGender(request.gender())
                .build();
        return BorrowerMapper.fromBorrower(borrower);
    }

    private void checkIfBorrowerExists(@NotNull @Size(min=9, max=9) String ssn) {
        Mono<Boolean> exists = repository.findBySsn(ssn).hasElement();
        Mono<Boolean> trueStatement = Mono.just(true);
        if (exists.equals(trueStatement)) {
            throw new DuplicatedSsnException();
        }
    }
    
}
