package com.trading.tradingpagebackend.service;

import com.trading.tradingpagebackend.model.Form;
import com.trading.tradingpagebackend.repository.FormRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class FormServiceTest {
    @Autowired private FormService formService;
    @MockitoBean private FormRepository formRepository;

    String email = "sebafvs@gmail.com";

    @Test
    void saveFormEmailAlreadyInUse() {
        Mockito.when(
                formRepository.existsByEmail(email)
        ).thenReturn(
                Mono.just(true)
        );

        StepVerifier.create(
                formService.saveForm(mockForm())
        ).expectError(IllegalArgumentException.class).verify();
    }

    @Test
    void saveFormSuccessfully() {
        Mockito.when(
                formRepository.existsByEmail(email)
        ).thenReturn(
                Mono.just(false)
        );

        Mockito.when(
                formRepository.save(mockForm())
        ).thenReturn(
                Mono.just(mockForm())
        );

        StepVerifier.create(
                formService.saveForm(mockForm())
        ).expectNextCount(1).verifyComplete();
    }

    private Form mockForm() {
        return Form.builder()
                .name("Seba")
                .email(email)
                .phone("123456789")
                .experience(true)
                .strategy("ICT")
                .hasAccount(true)
                .accountBalance("100,000$")
                .goal("10% of my account, montly!")
                .job("Developer")
                .salary("1000$")
                .amountGoal("10,000$")
                .missingFromAchievingGoal("Emotions")
                .investmentAmount("2000$")
                .build();
    }

}
