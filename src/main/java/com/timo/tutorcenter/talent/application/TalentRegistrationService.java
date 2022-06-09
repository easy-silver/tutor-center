package com.timo.tutorcenter.talent.application;

import com.timo.tutorcenter.accounts.domain.Accounts;
import com.timo.tutorcenter.accounts.domain.AccountsRepository;
import com.timo.tutorcenter.accounts.exception.AccountNotFoundException;
import com.timo.tutorcenter.category.domain.CateMain;
import com.timo.tutorcenter.category.domain.CateMainRepository;
import com.timo.tutorcenter.category.domain.CateSub;
import com.timo.tutorcenter.category.domain.CateSubRepository;
import com.timo.tutorcenter.category.exception.CategoryNotFoundException;
import com.timo.tutorcenter.talent.application.command.NewTalentCommand;
import com.timo.tutorcenter.talent.domain.Talent;
import com.timo.tutorcenter.talent.domain.TalentRepository;
import com.timo.tutorcenter.talent.exception.TalentNotFoundException;
import com.timo.tutorcenter.talent.web.dto.SelectTalentTypeRequest;
import com.timo.tutorcenter.talent.web.dto.TalentCreateResponse;
import com.timo.tutorcenter.talent.web.dto.SelectTalentTypeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class TalentRegistrationService {

    private final AccountsRepository accountsRepository;
    private final CateMainRepository cateMainRepository;
    private final CateSubRepository cateSubRepository;
    private final TalentRepository talentRepository;

    public TalentCreateResponse newTalent(SelectTalentTypeRequest request) {
        Accounts owner = findOwner(request.getOwnerId());
        CateMain cateMain = cateMainRepository.findById(request.getCateMainId())
                .orElseThrow(CategoryNotFoundException::new);
        CateSub cateSub = cateSubRepository.findById(request.getCateSubId())
                .orElseThrow(CategoryNotFoundException::new);

        Talent talent = NewTalentCommand.builder()
                .owner(owner)
                .talentType(request.getTalentType())
                .cateMain(cateMain)
                .cateSub(cateSub)
                .minPerson(request.getMinPerson())
                .maxPerson(request.getMaxPerson())
                .groupAvailable(request.getGroupAvailable())
                .totalTimes(request.getTotalTimes())
                .build()
                .toEntity();

        Long savedTalentId = talentRepository.save(talent).getId();

        return new TalentCreateResponse(savedTalentId);
    }

    public SelectTalentTypeResponse getTalentTypeAndCategory(Long talentId, Long ownerId) {
        Accounts owner = findOwner(ownerId);
        Talent talent = talentRepository.findByIdAndOwner(talentId, owner)
                .orElseThrow(TalentNotFoundException::new);

        return new SelectTalentTypeResponse(talent);
    }

    private Accounts findOwner(Long request) {
        return accountsRepository.findById(request)
                .orElseThrow(AccountNotFoundException::new);
    }

}
