package com.hhplus.task.concert.domain.concert.exception;

import com.hhplus.task.concert.domain.common.exception.DomainException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

public class SeatException extends DomainException {

    @Getter
    @RequiredArgsConstructor
    public enum SeatExceptionConst {
        SEAT_NOT_AVAILABLE(NOT_FOUND, "해당 좌석은 이용 불가능 합니다.")
        ;

        private final HttpStatus status;
        private final String msg;
    }

    public SeatException(SeatExceptionConst seatExceptionConst) {
        super(seatExceptionConst.getStatus(), seatExceptionConst.getMsg());
    }
}
