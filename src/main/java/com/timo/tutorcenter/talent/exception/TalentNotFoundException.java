package com.timo.tutorcenter.talent.exception;

public class TalentNotFoundException extends RuntimeException {

    public TalentNotFoundException() {
        super("존재하지 않는 클래스입니다.");
    }
}
