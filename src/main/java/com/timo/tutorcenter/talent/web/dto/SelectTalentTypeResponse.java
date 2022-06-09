package com.timo.tutorcenter.talent.web.dto;

import com.timo.tutorcenter.category.domain.CateMain;
import com.timo.tutorcenter.category.domain.CateSub;
import com.timo.tutorcenter.talent.domain.GroupAvailable;
import com.timo.tutorcenter.talent.domain.Talent;
import com.timo.tutorcenter.talent.domain.TalentType;
import lombok.Getter;

import java.util.Arrays;

@Getter
public class SelectTalentTypeResponse {

    private final Long talentId;
    private final String talentTypeTitle;
    private final TalentType talentType;
    private final Long cateMainId;
    private final String cateMainName;
    private final Long cateSubId;
    private final String cateSubName;
    private final Integer minPerson;
    private final Integer maxPerson;
    private final Integer totalTimes;
    private Boolean isOneOnOne;
    private Boolean isOneDay;

    public SelectTalentTypeResponse(Talent entity) {
        this.talentId = entity.getId();
        this.talentType = convertTalentType(entity.getMCategory());
        this.talentTypeTitle = talentType == null ? null : talentType.getTitle();

        CateMain cateMain = entity.getCateMain();
        CateSub cateSub = entity.getCateSub();
        this.cateMainId = cateMain == null ? null : cateMain.getId();
        this.cateMainName = cateMainId == null ? null : cateMain.getName();
        this.cateSubId = cateSub == null ? null : cateSub.getId();
        this.cateSubName = cateSubId == null ? null : cateSub.getName();

        GroupAvailable groupAvailable = convertGroupAvailable(entity.getGroupAvailable());
        if (groupAvailable != null) {
            this.isOneOnOne = groupAvailable.isOneOnOne();
            this.isOneDay = groupAvailable.isOneDay();
        }

        this.minPerson = entity.getMinPerson();
        this.maxPerson = entity.getMaxPerson();
        this.totalTimes = entity.getTotalTimes();
    }

    private TalentType convertTalentType(Integer typeValue) {
        return typeValue == null ? null :
                Arrays.stream(TalentType.values())
                        .filter(e -> e.getValue() == typeValue)
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("잘못된 클래스 타입 값"));
    }

    private GroupAvailable convertGroupAvailable(Integer value) {
        return value == null ? null :
                Arrays.stream(GroupAvailable.values())
                        .filter(e -> e.getValue() == value)
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("잘못된 참여 유형 값"));
    }
}
