package com.api.v1.borrower.services;

import com.api.v1.borrower.builders.BorrowerBuilder;
import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.dtos.BorrowerResponseDto;
import com.api.v1.borrower.dtos.NewBorrowerRequestDto;
import com.api.v1.borrower.mappers.BorrowerDtoResponseMapper;
import com.api.v1.borrower.utils.BorrowerFinderUtil;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
class UpdateBorrowerServiceImpl implements UpdateBorrowerService {

    @Autowired
    private BorrowerRepository repository;

    @Autowired
    private BorrowerFinderUtil finder;

    @Override
    public Mono<BorrowerResponseDto> update(@Valid NewBorrowerRequestDto request) {
        return finder
            .find(request.ssn())
            .flatMap(borrower -> {
                Borrower archivedBorrower = borrower.archive();
                return repository.save(archivedBorrower);
            })
            .then(Mono.defer(() -> {
                Borrower updatedBorrower = BorrowerBuilder.create().fromDto(request).build();
                return repository.save(updatedBorrower).flatMap(b -> Mono.just(BorrowerDtoResponseMapper.map(b)));
            }));
    }

}
