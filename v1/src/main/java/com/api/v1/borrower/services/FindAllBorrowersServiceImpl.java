package com.api.v1.borrower.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.mappers.BorrowerDtoResponseMapper;
import com.api.v1.borrower.dtos.BorrowerResponseDto;

import reactor.core.publisher.Flux;

@Service
class FindAllBorrowersServiceImpl implements FindAllBorrowersService {

    @Autowired
    private BorrowerRepository repository;

    @Override
    public Flux<BorrowerResponseDto> findAll() {
        return repository
            .findAll()
            .flatMap(b -> Flux.just(BorrowerDtoResponseMapper.map(b)));
    }
    
}