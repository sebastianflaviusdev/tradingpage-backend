package com.trading.tradingpagebackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "form")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Form {
    @Id
    private Long id;

    private String name;
    private String email;
    private String phone;

    private Boolean experience;
    private String strategy;

    @Column("has_account")
    private Boolean hasAccount;
    @Column("account_balance")
    private String accountBalance;

    private String goal;
    private String job;

    private String salary;
    @Column("amount_goal")
    private String amountGoal;

    @Column("missing_from_achieving_goal")
    private String missingFromAchievingGoal;

    @Column("investment_amount")
    private String investmentAmount;
}
