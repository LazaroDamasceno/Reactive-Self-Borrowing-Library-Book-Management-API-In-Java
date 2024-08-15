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
import com.api.v1.borrow.exceptions.BorrowLimitReachedException;
import reactor.core.publisher.Mono;

@Service
class BookBorrowServiceImpl implements BookBorrowService {

    @Autowired
    private BorrowRepository repository;

    @Autowired
    private BookFinderUtil bookFinder;

    @Autowired
    private BorrowerFinderUtil borrowerFinder;

    private final Long BORROW_LIMIT = 3L;

    @Override
    public Mono<BorrowResponseDto> borrowBook(@ISBN String isbn, @SSN String ssn) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return Mono.zip(bookMono, borrowerMono)
            .flatMap(tuple -> {
                Book book = tuple.getT1();
                Borrower borrower = tuple.getT2();
                return response(book, borrower);
            });
    }

    private Mono<BorrowResponseDto> response(Book book, Borrower borrower) {
        return repository
            .countHowManyActiveBorrowsByBorrower(borrower)
            .flatMap(count -> {
                if (count.equals(BORROW_LIMIT)) {
                    return handleBorrowLimitReached();
                } 
                else {
                    return handleBorrow(book, borrower);
                }
            });         
    }

    private Mono<BorrowResponseDto> handleBorrowLimitReached() {
        return Mono.error(new BorrowLimitReachedException());
    }

    private Mono<BorrowResponseDto> handleBorrow(Book book, Borrower borrower) {
        return Mono.defer(() -> {
            NewBorrowRequestDto dto = new NewBorrowRequestDto(book, borrower);
            Borrow borrow = BorrowBuilder.fromDto(dto).build();
            Mono<Borrow> savedBorrow = repository.save(borrow);
            return savedBorrow.flatMap(e -> Mono.just(BorrowResponseMapper.map(e)));
        });
    }

}
