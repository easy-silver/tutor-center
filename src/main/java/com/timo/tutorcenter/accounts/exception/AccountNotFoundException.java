package com.timo.tutorcenter.accounts.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException() {
        super("존재하지 않는 회원입니다.");
    }
}
