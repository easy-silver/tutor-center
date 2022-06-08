package com.timo.tutorcenter.talent.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GroupAvailable {

    MULTI_TIMES_AND_ONE(0),
    MULTI_TIMES_AND_GROUP(1),
    ONE_DAY_AND_ONE(2),
    ONE_DAY_AND_GROUP(3);

    private final int value;
}
