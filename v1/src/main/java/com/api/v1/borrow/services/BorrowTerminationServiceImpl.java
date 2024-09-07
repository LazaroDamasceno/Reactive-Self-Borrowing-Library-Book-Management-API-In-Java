package com.api.v1.borrow.services;

import com.api.v1.borrow.domain.BorrowRepository;
import com.api.v1.borrow.dtos.BorrowResponseDto;
import com.api.v1.borrow.mappers.BorrowResponseMapper;
import com.api.v1.borrow.utils.BorrowFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class BorrowTerminationServiceImpl implements BorrowTerminationService {

    @Autowired
    private BorrowRepository repository;

    @Autowired
    private BorrowFinderUtil borrowFinderUtil;

    @Override
    public Mono<Void> terminate(String id) {
        return borrowFinderUtil
                .find(id)
                .flatMap(borrow -> {
                    borrow.terminateBorrow();
                    return repository.save(borrow).then();
                });
    }

}
