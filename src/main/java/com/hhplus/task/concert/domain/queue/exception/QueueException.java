package com.hhplus.task.concert.domain.queue.exception;

import com.hhplus.task.concert.domain.common.exception.DomainException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

public class QueueException extends DomainException {

    @Getter
    @RequiredArgsConstructor
    public enum QueueExceptionConst {
        TOKEN_NOT_FOUND(NOT_FOUND, "대기열이 만료되었습니다.");

        private final HttpStatus status;
        private final String msg;
    }

    public QueueException(QueueExceptionConst queueExceptionConst) {
        super(queueExceptionConst.getStatus(), queueExceptionConst.getMsg());
    }
}
