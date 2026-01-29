package com.nouah.metroestate.exception;

public class MetroException extends RuntimeException {
    public MetroException(String message) {
        super(message);
    }

    public MetroException() {
        super("Error processing request at the moment.");
    }

      public MetroException(String message, Throwable cause) {
        super(message, cause);
    }

    public MetroException(Throwable cause) {
        super(cause);
    }

    public MetroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
