package com.trading.tradingpagebackend.controller;

import com.trading.tradingpagebackend.model.Form;
import com.trading.tradingpagebackend.service.FormService;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.reactor.ratelimiter.operator.RateLimiterOperator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/form")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class FormController {
    private final FormService formService;
    private final RateLimiter rateLimiterForm;

    @PostMapping
    public Mono<Form> saveForm(@RequestBody Form formData) {
        return formService.saveForm(formData)
                .transformDeferred(RateLimiterOperator.of(rateLimiterForm));
    }
}
