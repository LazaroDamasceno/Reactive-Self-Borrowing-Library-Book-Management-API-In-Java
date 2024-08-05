package com.api.v1.borrower.services;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.dtos.BorrowerResponse;
import com.api.v1.borrower.dtos.UpdatedBorrowerRequest;
import com.api.v1.borrower.mapper.BorrowerMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class UpdateBorrowerServiceImpl implements UpdateBorrowerService {

    @Autowired
    private BorrowerRepository repository;

    @Override
    public Mono<BorrowerResponse> update(
            @NotNull @Size(min=9, max=9) String ssn,
            @Valid UpdatedBorrowerRequest request
    ) {
        Mono<Borrower> monoBorrower = repository
                .getBySsn(ssn)
                .switchIfEmpty(Mono.defer(
                        () -> Mono.error(new IllegalArgumentException("Borrower was not found.")
                )));
        Mono<Borrower> savedBorrower = monoBorrower
                .flatMap(borrower -> {
                    borrower.update(
                            request.firstName(),
                            request.middleName(),
                            request.lastName(),
                            request.email(),
                            request.address(),
                            request.phoneNumber(),
                            request.gender());
                    return repository.save(borrower);
        });
        return BorrowerMapper.mapFromBorrower(savedBorrower);
    }

}
