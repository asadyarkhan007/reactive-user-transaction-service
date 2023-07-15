package com.transactionservice.exception;

public class NameAlreadyExistException extends RuntimeException {
    public NameAlreadyExistException() {
    }

    public NameAlreadyExistException(String message) {
        super(message);
    }

    public NameAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
