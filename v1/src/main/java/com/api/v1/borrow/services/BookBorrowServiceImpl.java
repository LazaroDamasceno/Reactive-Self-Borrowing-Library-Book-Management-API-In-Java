package com.api.v1.borrow.services;

import com.api.v1.annotations.ISBN;
import com.api.v1.annotations.SSN;
import com.api.v1.book.domain.Book;
import com.api.v1.book.utils.BookFinderUtil;
import com.api.v1.borrow.builders.BorrowBuilder;
import com.api.v1.borrow.domain.Borrow;
import com.api.v1.borrow.domain.BorrowRepository;
import com.api.v1.borrow.dtos.BorrowResponseDto;
import com.api.v1.borrow.dtos.NewBorrowRequestDto;
import com.api.v1.borrow.mappers.BorrowResponseMapper;
import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.utils.BorrowerFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class BookBorrowServiceImpl implements BookBorrowService {

    @Autowired
    private BorrowRepository repository;

    @Autowired
    private BookFinderUtil bookFinder;

    @Autowired
    private BorrowerFinderUtil borrowerFinder;

    @Override
    public Mono<BorrowResponseDto> borrowBook(@ISBN String isbn, @SSN String ssn) {
        var bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return Mono
                .zip(bookMono, borrowerMono)
                .flatMap(tuple -> {
                    Book book = tuple.getT1();
                    Borrower borrower = tuple.getT2();
                    NewBorrowRequestDto request = new NewBorrowRequestDto(book, borrower);
                    Borrow borrow = BorrowBuilder.fromDto(request).build();
                    return Mono.just(borrow);
                })
                .flatMap(repository::save)
                .flatMap(b -> Mono.just(BorrowResponseMapper.map(b)));
    }

}
