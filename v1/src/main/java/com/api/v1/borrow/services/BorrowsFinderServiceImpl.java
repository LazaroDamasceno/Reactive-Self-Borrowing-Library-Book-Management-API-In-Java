package com.api.v1.borrow.services;

import com.api.v1.annotations.ISBN;
import com.api.v1.annotations.SSN;
import com.api.v1.book.utils.BookFinderUtil;
import com.api.v1.borrow.domain.Borrow;
import com.api.v1.borrow.domain.BorrowRepository;
import com.api.v1.borrow.dtos.BorrowResponseDto;
import com.api.v1.borrow.mappers.BorrowResponseMapper;
import com.api.v1.borrower.utils.BorrowerFinderUtil;
import com.api.v1.exceptions.EmptyFluxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;

@Service
class BorrowsFinderServiceImpl implements BorrowsFinderService {
    
    @Autowired
    private BorrowRepository repository;

    @Autowired
    private BookFinderUtil bookFinderUtil;

    @Autowired
    private BorrowerFinderUtil borrowerFinderUtil;

    @Override
    public Flux<BorrowResponseDto> findAllActive(int firstYear, int lastYear) {
        return repository
                .findAll()
                .hasElements()
                .flatMapMany(exists -> {
                    if (!exists) return Mono.error(EmptyFluxException::new);
                    return findActive(firstYear, lastYear)
                            .flatMap(b -> Flux.just(BorrowResponseMapper.map(b)));
                });
    }

    @Override
    public Flux<BorrowResponseDto> findActiveByAuthor(String author, int firstYear, int lastYear) {
        return repository
                .findAll()
                .hasElements()
                .flatMapMany(exists -> {
                    if (!exists) return Mono.error(EmptyFluxException::new);
                    return findActive(firstYear, lastYear)
                            .filter(e -> e.getBook().getAuthor().equals(author))
                            .flatMap(b -> Flux.just(BorrowResponseMapper.map(b)));
                });
    }

    @Override
    public Flux<BorrowResponseDto> findActiveByBook(@ISBN String isbn, int firstYear, int lastYear) {
        return bookFinderUtil
                .find(isbn)
                .flatMapMany(book -> repository
                        .findAll()
                        .hasElements()
                        .flatMapMany(exists -> {
                            if (!exists) return Mono.error(EmptyFluxException::new);
                            return findActive(firstYear, lastYear)
                                    .filter(e -> e.getBook().getIsbn().equals(isbn))
                                    .flatMap(b -> Flux.just(BorrowResponseMapper.map(b)));
                        }));
    }

    @Override
    public Flux<BorrowResponseDto> findActiveByBorrower(@SSN String ssn, int firstYear, int lastYear) {
        return borrowerFinderUtil
                .find(ssn)
                .flatMapMany(borrower -> repository
                        .findAll()
                        .hasElements()
                        .flatMapMany(exists -> {
                            if (!exists) return Mono.error(EmptyFluxException::new);
                            return findActive(firstYear, lastYear)
                                    .filter(e -> e.getBorrower().getSsn().equals(ssn))
                                    .flatMap(b -> Flux.just(BorrowResponseMapper.map(b)));
                        }));
    }

    @Override
    public Flux<BorrowResponseDto> findAllOverdue(int firstYear, int lastYear) {
        return repository
                .findAll()
                .hasElements()
                .flatMapMany(exists -> {
                    if (!exists) return Mono.error(EmptyFluxException::new);
                    return findOverdue(firstYear, lastYear)
                            .flatMap(b -> Flux.just(BorrowResponseMapper.map(b)));
                });
    }

    @Override
    public Flux<BorrowResponseDto> findOverdueByAuthor(String author, int firstYear, int lastYear) {
        return repository
                .findAll()
                .hasElements()
                .flatMapMany(exists -> {
                    if (!exists) return Mono.error(EmptyFluxException::new);
                    return findOverdue(firstYear, lastYear)
                            .filter(e -> e.getBook().getAuthor().equals(author))
                            .flatMap(b -> Flux.just(BorrowResponseMapper.map(b)));
                });
    }

    @Override
    public Flux<BorrowResponseDto> findOverdueByBook(@ISBN String isbn, int firstYear, int lastYear) {
        return bookFinderUtil
                .find(isbn)
                .flatMapMany(book -> repository
                        .findAll()
                        .hasElements()
                        .flatMapMany(exists -> {
                            if (!exists) return Mono.error(EmptyFluxException::new);
                            return findOverdue(firstYear, lastYear)
                                    .filter(e -> e.getBook().getIsbn().equals(isbn))
                                    .flatMap(b -> Flux.just(BorrowResponseMapper.map(b)));

                }));
    }

    @Override
    public Flux<BorrowResponseDto> findOverdueByBorrower(@SSN String ssn, int firstYear, int lastYear) {
        return borrowerFinderUtil
                .find(ssn)
                .flatMapMany(borrower -> repository
                    .findAll()
                    .hasElements()
                    .flatMapMany(exists -> {
                        if (!exists) return Mono.error(EmptyFluxException::new);
                        return findOverdue(firstYear, lastYear)
                                .filter(e -> e.getBorrower().getSsn().equals(ssn))
                                .flatMap(b -> Flux.just(BorrowResponseMapper.map(b)));
                }));
    }

    @Override
    public Flux<BorrowResponseDto> findAllTerminated(int firstYear, int lastYear) {
        return repository
                .findAll()
                .hasElements()
                .flatMapMany(exists -> {
                    if (!exists) return Mono.error(EmptyFluxException::new);
                    return findTerminated(firstYear, lastYear)
                            .flatMap(b -> Flux.just(BorrowResponseMapper.map(b)));
                });
    }

    @Override
    public Flux<BorrowResponseDto> findTerminatedByAuthor(String author, int firstYear, int lastYear) {
        return repository
                .findAll()
                .hasElements()
                .flatMapMany(exists -> {
                    if (!exists) return Mono.error(EmptyFluxException::new);
                    return findTerminated(firstYear, lastYear)
                            .filter(e -> e.getBook().getAuthor().equals(author))
                            .flatMap(b -> Flux.just(BorrowResponseMapper.map(b)));
                });
    }

    @Override
    public Flux<BorrowResponseDto> findTerminatedByBook(@ISBN String isbn, int firstYear, int lastYear) {
        return bookFinderUtil
                .find(isbn)
                .flatMapMany(book -> repository
                .findAll()
                .hasElements()
                .flatMapMany(exists -> {
                    if (!exists) return Mono.error(EmptyFluxException::new);
                    return findTerminated(firstYear, lastYear)
                            .filter(e -> e.getBook().getIsbn().equals(isbn))
                            .flatMap(b -> Flux.just(BorrowResponseMapper.map(b)));
                }));
    }

    @Override
    public Flux<BorrowResponseDto> findTerminatedByBorrower(@SSN String ssn, int firstYear, int lastYear) {
        return borrowerFinderUtil
                .find(ssn)
                .flatMapMany(borrower -> repository
                .findAll()
                .hasElements()
                .flatMapMany(exists -> {
                    if (!exists) return Mono.error(EmptyFluxException::new);
                    return findTerminated(firstYear, lastYear)
                            .filter(e -> e.getBorrower().getSsn().equals(ssn))
                            .flatMap(b -> Flux.just(BorrowResponseMapper.map(b)));
                }));
    }
    
    private Flux<Borrow> findActive(int firstYear, int lastYear) {
        return repository
                .findAll()
                .filter(e -> e.getReturningDate() == null
                        && (ZonedDateTime.parse(e.getBorrowingDate()).getYear() >= firstYear
                        && ZonedDateTime.parse(e.getBorrowingDate()).getYear() <= lastYear)
                );
    }

    private Flux<Borrow> findOverdue(int firstYear, int lastYear) {
        return repository
                .findAll()
                .filter(e -> e.getReturningDate() != null
                        && (
                                ZonedDateTime.parse(e.getDueDate()).isBefore(ZonedDateTime.now())
                                || ZonedDateTime.parse(e.getExtendedDueDate()).isBefore(ZonedDateTime.now())
                        )
                        && (ZonedDateTime.parse(e.getBorrowingDate()).getYear() >= firstYear
                        && ZonedDateTime.parse(e.getBorrowingDate()).getYear() <= lastYear)
                );
    }

    private Flux<Borrow> findTerminated(int firstYear, int lastYear) {
        return repository
                .findAll()
                .filter(e -> e.getReturningDate() != null
                        && (ZonedDateTime.parse(e.getBorrowingDate()).getYear() >= firstYear
                        && ZonedDateTime.parse(e.getBorrowingDate()).getYear() <= lastYear)
                );
    }
    
}
