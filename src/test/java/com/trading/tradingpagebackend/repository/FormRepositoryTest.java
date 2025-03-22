package com.trading.tradingpagebackend.repository;

import com.trading.tradingpagebackend.model.Form;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import reactor.test.StepVerifier;

@SpringBootTest
@ActiveProfiles("test")
public class FormRepositoryTest {
    @Autowired private FormRepository formRepository;

    @BeforeEach
    void setup() {
        StepVerifier.create(formRepository.deleteAll()).verifyComplete();
    }

    @AfterEach
    void taerdown() {
        StepVerifier.create(formRepository.deleteAll()).verifyComplete();
    }

    @Test
    void save() {
        Form form = Form.builder()
                .name("Seba")
                .email("sebafvs@gmail.com")
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

        StepVerifier.create(
                formRepository.save(form)
        ).expectNextCount(1).verifyComplete();
    }

}
