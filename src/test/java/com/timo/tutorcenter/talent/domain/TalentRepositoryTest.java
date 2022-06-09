package com.timo.tutorcenter.talent.domain;

import com.timo.tutorcenter.accounts.domain.Accounts;
import com.timo.tutorcenter.accounts.domain.AccountsRepository;
import com.timo.tutorcenter.category.domain.CateMain;
import com.timo.tutorcenter.category.domain.CateMainRepository;
import com.timo.tutorcenter.category.domain.CateSub;
import com.timo.tutorcenter.category.domain.CateSubRepository;
import com.timo.tutorcenter.talent.application.command.NewTalentCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TalentRepositoryTest {

    @Autowired TalentRepository talentRepository;
    @Autowired AccountsRepository accountsRepository;
    @Autowired CateMainRepository cateMainRepository;
    @Autowired CateSubRepository cateSubRepository;

    @DisplayName("오프라인 클래스 신규 생성")
    @Test
    void newOfflineTalent() {
        //given
        Accounts tester = accountsRepository.findById(1L).get();
        CateMain cateMain = cateMainRepository.findById(24L).get();
        CateSub cateSub = cateSubRepository.findAllByCateMain(cateMain).get(0);

        NewTalentCommand newTalentCommand = NewTalentCommand.builder()
                .owner(tester)
                .cateMain(cateMain)
                .cateSub(cateSub)
                .build();

        //when
        Talent offlineTalent = Talent.createOfflineTalent(newTalentCommand);
        Talent savedTalent = talentRepository.save(offlineTalent);

        //then
        assertThat(savedTalent.getMCategory()).isEqualTo(TalentType.OFFLINE.getValue());
    }

    @DisplayName("클래스 아이디와 튜터 아이디로 조회")
    @Test
    void findByIdAndOwner() {
        Accounts tester = accountsRepository.findById(1L).get();
        CateMain cateMain = cateMainRepository.findById(24L).get();
        CateSub cateSub = cateSubRepository.findAllByCateMain(cateMain).get(0);

        Talent talent = Talent.createOfflineTalent(NewTalentCommand.builder()
                .owner(tester)
                .cateMain(cateMain)
                .cateSub(cateSub).build());

        Long savedTalentId = talentRepository.save(talent).getId();

        //when
        Talent findTalent = talentRepository.findByIdAndOwner(savedTalentId, tester).get();

        //then
        assertThat(findTalent.getCateMain().getName()).isEqualTo(cateMain.getName());
    }

}