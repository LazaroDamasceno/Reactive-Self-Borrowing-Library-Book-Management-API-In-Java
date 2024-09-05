package com.api.v1.borrower.services;

import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.dtos.BorrowerResponseDto;
import com.api.v1.borrower.dtos.NewBorrowerRequestDto;
import com.api.v1.borrower.mappers.BorrowerResponseMapper;
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
            .flatMap(existingBorrower -> {
                existingBorrower.update(request);
                return repository.save(existingBorrower);
            })
            .flatMap(updateBorrower -> Mono.just(BorrowerResponseMapper.map(updateBorrower)));

    }

}
