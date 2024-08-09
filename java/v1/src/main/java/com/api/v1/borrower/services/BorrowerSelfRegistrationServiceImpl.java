package com.api.v1.borrower.services;

import com.api.v1.borrower.builder.BorrowerBuilder; // Use consistent naming convention
import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.helpers.NewBorrowerRequestDto; // Use DTO for clarity

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
class BorrowerSelfRegistrationServiceImpl implements BorrowerSelfRegistrationService {

    @Autowired
    private BorrowerRepository repository;

    @Override
    public Mono<Borrower> selfRegister(@Valid NewBorrowerRequestDto request) {
        return repository.getBySsn(request.ssn())
                .filter(Objects::nonNull)
                .switchIfEmpty(Mono.defer(() -> {
                        Borrower borrower = BorrowerBuilder.fromDto(request).build();
                        return Mono.just(borrower).flatMap(repository::save);
                    }
                )
        );
    }

}
