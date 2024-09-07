package com.api.v1.borrow.services;

import com.api.v1.borrow.dtos.BorrowResponseDto;
import com.api.v1.borrow.mappers.BorrowResponseMapper;
import com.api.v1.borrow.utils.BorrowFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class BorrowFinderServiceImpl implements BorrowFinderService {

    @Autowired
    private BorrowFinderUtil borrowFinderUtil;

    @Override
    public Mono<BorrowResponseDto> find(String id) {
        return borrowFinderUtil
                .findActiveBorrow(id)
                .flatMap(b -> Mono.just(BorrowResponseMapper.map(b)));
    }

}
