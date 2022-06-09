package com.timo.tutorcenter.talent.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GroupAvailable {

    MULTI_TIMES_AND_ONE(0, false, true),
    MULTI_TIMES_AND_GROUP(1, false, false),
    ONE_DAY_AND_ONE(2, true, true),
    ONE_DAY_AND_GROUP(3, true, false);

    private final int value;
    private final boolean isOneOnOne;
    private final boolean isOneDay;
}
