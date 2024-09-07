package com.api.v1.borrow.services;

import com.api.v1.borrow.dtos.BorrowResponseDto;
import reactor.core.publisher.Flux;

public interface BorrowsFinderService {

    Flux<BorrowResponseDto> findAllActive(int firstYear, int lastYear);
    Flux<BorrowResponseDto> findActiveByAuthor(String author, int firstYear, int lastYear);
    Flux<BorrowResponseDto> findActiveByBook(String isbn, int firstYear, int lastYear);
    Flux<BorrowResponseDto> findActiveByBorrower(String ssn, int firstYear, int lastYear);
    Flux<BorrowResponseDto> findAllOverdue(int firstYear, int lastYear);
    Flux<BorrowResponseDto> findOverdueByAuthor(String author, int firstYear, int lastYear);
    Flux<BorrowResponseDto> findOverdueByBook(String isbn, int firstYear, int lastYear);
    Flux<BorrowResponseDto> findOverdueByBorrower(String ssn, int firstYear, int lastYear);
    Flux<BorrowResponseDto> findAllTerminated(int firstYear, int lastYear);
    Flux<BorrowResponseDto> findTerminatedByAuthor(String author, int firstYear, int lastYear);
    Flux<BorrowResponseDto> findTerminatedByBook(String isbn, int firstYear, int lastYear);
    Flux<BorrowResponseDto> findTerminatedByBorrower(String ssn, int firstYear, int lastYear);

}
