package com.timo.tutorcenter.accounts.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AccountsRepositoryTest {

    @Autowired
    AccountsRepository repository;

    @Test
    void save() {
        Accounts accounts = new Accounts(1L, "티모", "timo@mail.com");
        Accounts savedAccounts = repository.save(accounts);

        assertThat(savedAccounts.getName()).isEqualTo(accounts.getName());
    }
}