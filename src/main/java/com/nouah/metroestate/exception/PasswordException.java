package com.nouah.metroestate.exception;

import com.nouah.metroestate.model.enums.ResponseStatus;

public class PasswordException extends UserException {

    public PasswordException(String message) {
        super(message);
    }

    public PasswordException(ResponseStatus status) {
        super(status);
    }

    public PasswordException(ResponseStatus status, Object details) {
        super(status, details);
    }

    public PasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordException(ResponseStatus status, Throwable cause) {
        super(status, cause);
    }
}
