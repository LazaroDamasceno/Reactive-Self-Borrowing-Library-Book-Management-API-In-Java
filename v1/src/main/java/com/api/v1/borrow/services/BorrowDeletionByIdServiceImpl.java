package com.api.v1.borrow.services;

import com.api.v1.borrow.domain.BorrowRepository;
import com.api.v1.borrow.utils.BorrowFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class BorrowDeletionByIdServiceImpl implements BorrowDeletionByIdService {

    @Autowired
    private BorrowFinderUtil borrowFinderUtil;

    @Autowired
    private BorrowRepository repository;

    @Override
    public Mono<Void> deleteById(String id) {
        return borrowFinderUtil
                .find(id)
                .flatMap(borrow -> repository.delete(borrow));
    }

}
