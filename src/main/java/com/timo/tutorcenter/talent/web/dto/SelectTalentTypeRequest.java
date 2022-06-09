package com.timo.tutorcenter.talent.web.dto;

import com.timo.tutorcenter.talent.domain.GroupAvailable;
import com.timo.tutorcenter.talent.domain.TalentType;
import lombok.Getter;

@Getter
public class SelectTalentTypeRequest {

    private Long ownerId;

    private TalentType talentType;

    private Long cateMainId;

    private Long cateSubId;

    private Integer minPerson;

    private Integer maxPerson;

    private Boolean isOneOnOne;

    private Boolean isOneDay;

    private Integer totalTimes;

    public GroupAvailable getGroupAvailable() {
        if (isOneOnOne == null || isOneDay == null) {
            return null;
        }

        if(isMultiTimes() && isOneOnOne) {
            return GroupAvailable.MULTI_TIMES_AND_ONE;

        } else if (isMultiTimes() && isGroup()) {
            return GroupAvailable.MULTI_TIMES_AND_GROUP;

        } else if (isOneDay && isOneOnOne) {
            return GroupAvailable.ONE_DAY_AND_ONE;

        } else if (isOneDay && isGroup()) {
            return GroupAvailable.ONE_DAY_AND_GROUP;
        }

        throw new IllegalArgumentException();
    }

    public Boolean isGroup() {
        return isOneOnOne == null ? null : !isOneOnOne;
    }

    public Boolean isMultiTimes() {
        return isOneDay == null ? null : !isOneDay;
    }

}
