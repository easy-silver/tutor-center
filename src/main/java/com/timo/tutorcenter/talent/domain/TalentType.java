package com.timo.tutorcenter.talent.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TalentType {
    OFFLINE("오프라인", 1),
    ONLINE("온라인 LIVE", 2),
    RECORDING("녹화영상", 3),
    EBOOK("전자책", 4);

    private final String title;
    private final int value;
}
