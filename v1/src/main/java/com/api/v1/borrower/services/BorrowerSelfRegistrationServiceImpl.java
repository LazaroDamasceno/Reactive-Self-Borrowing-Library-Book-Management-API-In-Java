package com.api.v1.borrower.services;

import com.api.v1.borrower.helpers.BorrowerMonoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.borrower.builder.BorrowerBuilder;
import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.helpers.NewBorrowerRequest;
import com.api.v1.borrower.helpers.BorrowerResponse;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@Service
class BorrowerSelfRegistrationServiceImpl implements BorrowerSelfRegistrationService {

    @Autowired
    private BorrowerRepository repository;
    
    @Override
    public Mono<BorrowerResponse> sefRegister(@Valid NewBorrowerRequest request) {
        Borrower borrower = BorrowerBuilder
            .create()
            .withFirstName(request.firstName())
            .withMiddleName(request.middleName())
            .withLastName(request.lastName())
            .withSsn(request.ssn())
            .withEmail(request.email())
            .withPhoneNumber(request.phoneNumber())
            .withAddress(request.address())
            .withGender(request.gender())
            .build();
        Mono<Borrower> savedBorrower = repository.save(borrower);
        return BorrowerMonoMapper.mapFromMono(savedBorrower);
    }
    
}
