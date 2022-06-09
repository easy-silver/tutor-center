package com.timo.tutorcenter.talent.application.command;

import com.timo.tutorcenter.accounts.domain.Accounts;
import com.timo.tutorcenter.category.domain.CateMain;
import com.timo.tutorcenter.category.domain.CateSub;
import com.timo.tutorcenter.talent.domain.GroupAvailable;
import com.timo.tutorcenter.talent.domain.Talent;
import com.timo.tutorcenter.talent.domain.TalentType;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class NewTalentCommand {

    private final Accounts owner;
    private final TalentType talentType;
    private final CateMain cateMain;
    private final CateSub cateSub;
    private final Integer minPerson;
    private final Integer maxPerson;
    private final Integer totalTimes;
    private final GroupAvailable groupAvailable;

    public Talent toEntity() {
        switch (talentType) {
            case OFFLINE:
                return Talent.createOfflineTalent(this);
            default:
                throw new IllegalArgumentException("유효하지 않은 클래스 타입입니다.");
        }
    }
}
