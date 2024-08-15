package com.api.v1.borrow.mappers;

import com.api.v1.borrow.domain.Borrow;
import com.api.v1.borrow.dtos.BorrowResponseDto;
import reactor.core.publisher.Flux;

public class BorrowFluxMapper {

    public static Flux<BorrowResponseDto> map(Flux<Borrow> flux) {
        return flux.flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

}
