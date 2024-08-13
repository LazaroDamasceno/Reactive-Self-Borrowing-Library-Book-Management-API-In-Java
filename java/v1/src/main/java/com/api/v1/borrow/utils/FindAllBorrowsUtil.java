package com.api.v1.borrow.utils;

import com.api.v1.book.domain.Book;
import com.api.v1.book.utils.BookFinderUtil;
import com.api.v1.borrow.domain.Borrow;
import com.api.v1.borrow.domain.BorrowRepository;
import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.utils.BorrowerFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.ZonedDateTime;

@Component
public class FindAllBorrowsUtil {
    
    @Autowired
    private BorrowRepository repository;

    @Autowired
    private BookFinderUtil bookFinder;

    @Autowired
    private BorrowerFinderUtil borrowerFinder;

    public Flux<Borrow> findAll() {
        return repository.findAll();
    }

    public Flux<Borrow> findActive() {
        return repository
                .findAll()
                .filter(e -> e.getReturnedDate() == null);
    }

    public Flux<Borrow> findOverdue() {
        return repository
                .findAll()
                .filter(e -> (ZonedDateTime.parse(e.getDueDate()).compareTo(getToday()) > 0 ||
                            ZonedDateTime.parse(e.getExtendedDueDate()).compareTo(getToday()) > 0
                        ) && e.getReturnedDate() == null
                );
    }

    private ZonedDateTime getToday() {
        int year = ZonedDateTime.now().getYear();
        int month = ZonedDateTime.now().getMonthValue();
        int day = ZonedDateTime.now().getDayOfMonth();
        var zone = ZonedDateTime.now().getZone();
        return ZonedDateTime.of(year, month, day, 0, 0, 0, 0, zone);
    }

    public Flux<Borrow> findFinished() {
        return repository
                .findAll()
                .filter(e -> e.getReturnedDate() != null);
    }
    
}
