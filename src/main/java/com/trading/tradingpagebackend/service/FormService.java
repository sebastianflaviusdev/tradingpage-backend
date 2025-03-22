package com.trading.tradingpagebackend.service;

import com.trading.tradingpagebackend.model.Form;
import com.trading.tradingpagebackend.repository.FormRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@Transactional
@RequiredArgsConstructor
public class FormService {
    private final FormRepository formRepository;

    public Mono<Form> saveForm(Form fromData) {
        return formRepository.existsByEmail(fromData.getEmail())
                .flatMap(exists -> {
                    if (exists) return Mono.error(new IllegalArgumentException("Email already exists"));
                    return formRepository.save(fromData);
            });
    }
}
