package com.api.v1.borrow;

import com.api.v1.borrower.dtos.BorrowerResponseDto;
import reactor.core.publisher.Mono;

public interface BorrowFinderService {

    Mono<BorrowResponseDto> find(String id);

}
