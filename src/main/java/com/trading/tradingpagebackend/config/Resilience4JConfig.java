package com.trading.tradingpagebackend.config;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class Resilience4JConfig {

    @Bean
    public RateLimiter rateLimiterForm() {
        return RateLimiter.of(
            "form", RateLimiterConfig.custom()
                    .timeoutDuration(Duration.ofSeconds(3))
                    .limitForPeriod(5)
                    .limitRefreshPeriod(Duration.ofSeconds(10))
                    .build()
        );
    }
}
