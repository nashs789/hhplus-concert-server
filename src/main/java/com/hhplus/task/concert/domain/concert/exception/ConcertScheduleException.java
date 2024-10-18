package com.hhplus.task.concert.domain.concert.exception;

import com.hhplus.task.concert.domain.common.exception.DomainException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class ConcertScheduleException extends DomainException {

    @Getter
    @RequiredArgsConstructor
    public enum ConcertScheduleExceptionConst {
        SCHEDULE_NOT_AVAILABLE(NOT_FOUND, "해당 스케줄은 이용 불가능 합니다.")
        ;

        private final HttpStatus status;
        private final String msg;
    }

    public ConcertScheduleException(ConcertScheduleExceptionConst concertScheduleExceptionConst) {
        super(concertScheduleExceptionConst.getStatus(), concertScheduleExceptionConst.getMsg());
    }
}
