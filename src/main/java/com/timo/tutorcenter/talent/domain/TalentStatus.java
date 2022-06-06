package com.timo.tutorcenter.talent.domain;

import lombok.Getter;

@Getter
public enum TalentStatus {
    TEST("테스트", -9),
    DELETED("삭제", -1),
    CREATED("수업 생성", 0),
    DENIED("수업 거절", 1),
    OPEN("수업 오픈", 2),
    STOP("운영 중지", 3),
    HOLD("약관 승인 대기", 8),
    EVALUATING("수업 평가중", 9);

    private final String title;
    private final int value;

    TalentStatus(String title, int value) {
        this.title = title;
        this.value = value;
    }
}