package com.trading.tradingpagebackend.repository;

import com.trading.tradingpagebackend.model.Form;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface FormRepository extends ReactiveCrudRepository<Form, Long> {

    Mono<Boolean> existsByEmail(String email);
}
