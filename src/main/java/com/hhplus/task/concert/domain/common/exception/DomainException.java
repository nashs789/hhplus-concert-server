package com.hhplus.task.concert.domain.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DomainException extends RuntimeException {

    private final HttpStatus status;

    public DomainException(HttpStatus status, String msg) {
        super(msg);
        this.status = status;
    }
}
