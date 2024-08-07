package com.api.v1.borrower.services;

import com.api.v1.borrower.helpers.BorrowerDtoResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.borrower.builder.BorrowerBuilder;
import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.helpers.NewBorrowerRequestDto;
import com.api.v1.borrower.helpers.BorrowerResponseDto;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@Service
class BorrowerSelfRegistrationServiceImpl implements BorrowerSelfRegistrationService {

    @Autowired
    private BorrowerRepository repository;
    
    @Override
    public Mono<BorrowerResponseDto> sefRegister(@Valid NewBorrowerRequestDto request) {
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
        return savedBorrower.flatMap(b -> Mono.just(BorrowerDtoResponseMapper.mapToDtoResponse(b)));
    }
    
}
