package com.api.v1.borrower.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.borrower.builder.BorrowerBuilder;
import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.helpers.dtos.BorrowerRequest;
import com.api.v1.borrower.helpers.dtos.BorrowerResponse;
import com.api.v1.borrower.helpers.mappers.MonoMapper;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@Service
final class BorrowerSelfRegistrationServiceImpl implements BorrowerSelfRegistrationService {

    @Autowired
    private BorrowerRepository repository;

    @Autowired
    private MonoMapper mapper;
    
    @Override
    public Mono<BorrowerResponse> sefRegister(@Valid BorrowerRequest request) {
        Borrower borrower = new BorrowerBuilder()
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
        return mapper.mapFromMono(savedBorrower);
    }
    
}
