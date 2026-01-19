package com.nouah.metroestate.exception;

public class ApiException extends RuntimeException {
    final int code;
    public ApiException(String message, int code) {
        super(message);
        this.code = code;
    }
}
