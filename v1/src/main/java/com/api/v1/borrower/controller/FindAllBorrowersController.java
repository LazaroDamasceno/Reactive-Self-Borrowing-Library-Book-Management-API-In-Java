package com.api.v1.borrower.controller;

import com.api.v1.borrower.services.FindAllBorrowersService;

@RestController
@RequestMapping("api/v1/borrowers")
class FindAllBorrowersController {

    @Autowired
    private FindAllBorrowersService service;

    @ResponseStatus(status = HttpStatus.OK)
    public Flux<BorrowerResponse> findAll() {
        return service.findAll();
    }

}