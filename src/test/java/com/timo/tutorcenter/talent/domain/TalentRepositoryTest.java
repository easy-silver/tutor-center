package com.timo.tutorcenter.talent.domain;

import com.timo.tutorcenter.accounts.domain.Accounts;
import com.timo.tutorcenter.accounts.domain.AccountsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TalentRepositoryTest {

    @Autowired AccountsRepository accountsRepository;
    @Autowired TalentRepository talentRepository;

    @Test
    void save() {
        //given
        Accounts owner = new Accounts(1L, "Timo", "timo@tailng.me");
        accountsRepository.save(owner);

        String title = "티모의 VOD 클래스";
        Talent talent = new Talent(owner, title, true);

        //when
        Talent savedTalent = talentRepository.save(talent);

        //then
        assertThat(savedTalent.getTitle()).isEqualTo(title);
    }

}