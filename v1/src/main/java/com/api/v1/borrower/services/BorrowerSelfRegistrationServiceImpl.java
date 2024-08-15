package com.api.v1.borrower.services;

import com.api.v1.borrower.builders.BorrowerBuilder;
import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.exceptions.DuplicatedSsnException;
import com.api.v1.borrower.dtos.NewBorrowerRequestDto;
import com.api.v1.borrower.dtos.BorrowerResponseDto;
import com.api.v1.borrower.mappers.BorrowerDtoResponseMapper;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class BorrowerSelfRegistrationServiceImpl implements BorrowerSelfRegistrationService {

    @Autowired
    private BorrowerRepository repository;

    @Override
    public Mono<BorrowerResponseDto> selfRegister(@Valid NewBorrowerRequestDto request) {
        return repository.getBySsn(request.ssn())
                .hasElement()
                .flatMap(exists -> {
                    if (exists) return duplicateSsnException();
                    else return defer(request);
                });
    }


    private Mono<BorrowerResponseDto> duplicateSsnException() {
        String message = "Input SSN is already used.";
        return Mono.error(new DuplicatedSsnException(message));
    }

    private Mono<BorrowerResponseDto> defer(NewBorrowerRequestDto request) {
        return Mono.defer(() -> {
            Borrower borrower = BorrowerBuilder.fromDto(request).build();
            Mono<Borrower> savedBorrower = repository.save(borrower);
            return savedBorrower.flatMap(b -> Mono.just(BorrowerDtoResponseMapper.map(b)));
        });
    }

}
