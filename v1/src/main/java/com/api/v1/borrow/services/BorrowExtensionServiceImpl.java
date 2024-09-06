package com.api.v1.borrow.services;

import com.api.v1.borrow.domain.BorrowRepository;
import com.api.v1.borrow.dtos.BorrowResponseDto;
import com.api.v1.borrow.exceptions.InextensibleBorrowException;
import com.api.v1.borrow.mappers.BorrowResponseMapper;
import com.api.v1.borrow.utils.BorrowFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class BorrowExtensionServiceImpl implements BorrowExtensionService {

    @Autowired
    private BorrowFinderUtil borrowFinderUtil;

    @Autowired
    private BorrowRepository repository;

    @Override
    public Mono<BorrowResponseDto> extend(String id) {
        return borrowFinderUtil
                .find(id)
                .flatMap(existingBorrow -> {
                    if (existingBorrow.getExtendedDueDate() != null || existingBorrow.getReturningDate() != null) {
                        return Mono.error(new InextensibleBorrowException(id));
                    }
                    existingBorrow.extendBorrow();
                    return repository.save(existingBorrow);
                })
                .flatMap(extendBorrow -> Mono.just(BorrowResponseMapper.map(extendBorrow)));
    }

}
