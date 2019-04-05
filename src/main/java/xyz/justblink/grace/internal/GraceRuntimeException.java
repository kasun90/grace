package xyz.justblink.grace.internal;

public class GraceRuntimeException extends Exception {
    public GraceRuntimeException() {

    }

    public GraceRuntimeException(String message) {
        super(message);
    }

    public GraceRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public GraceRuntimeException(Throwable cause) {
        super(cause);
    }

    public GraceRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
