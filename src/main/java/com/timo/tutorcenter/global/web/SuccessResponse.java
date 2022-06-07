package com.timo.tutorcenter.global.web;

import lombok.Getter;

@Getter
public class SuccessResponse<T> {

    private final String result;
    private final String reason;
    private final T data;

    private SuccessResponse(String result, String reason, T data) {
        this.result = result;
        this.reason = reason;
        this.data = data;
    }

    public static <T> SuccessResponse<T> success(T data) {
        return new SuccessResponse<>("success", "", data);
    }
}
