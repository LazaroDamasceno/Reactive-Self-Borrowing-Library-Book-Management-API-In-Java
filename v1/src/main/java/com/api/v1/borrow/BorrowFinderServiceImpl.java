package com.api.v1.borrow;

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
                .find(id)
                .flatMap(b -> Mono.just(BorrowResponseMapper.map(b)));
    }

}
