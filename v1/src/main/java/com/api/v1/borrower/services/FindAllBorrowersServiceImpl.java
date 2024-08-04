package com.api.v1.borrower.services;

import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.mapper.BorrowerMapper;

@Service
class FindAllBorrowersServiceImpl implements FindAllBorrowersService {

    @Autowired
    private BorrowerRepository repository;

    public Flux<BorrowerResponse> findAll() {
        Flux<Borrower> borrowers = repository.findAll();
        return BorrowerMapper.mapFromFlux(borrowers);
    }
    
}