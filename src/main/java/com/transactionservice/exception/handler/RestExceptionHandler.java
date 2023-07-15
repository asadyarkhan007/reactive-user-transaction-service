package com.transactionservice.exception.handler;

import com.transactionservice.exception.NameAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {
    @ExceptionHandler(NameAlreadyExistException.class)
    ResponseEntity nameAlreadyExists(NameAlreadyExistException ex) {
        log.error(ex.getMessage(),ex);
        return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(ex.getMessage());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    ResponseEntity duplicateKey(DuplicateKeyException ex) {
        log.error(ex.getMessage(),ex);
        return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity anyException(DuplicateKeyException ex) {
        log.error(ex.getMessage(),ex);
        return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(ex.getMessage());
    }
}
