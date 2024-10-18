package com.hhplus.task.concert.domain.user.exception;

import com.hhplus.task.concert.domain.common.exception.DomainException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class PointException extends DomainException {
    @Getter
    @RequiredArgsConstructor
    public enum PointExceptionConst {
        FAIL_LOAD_POINT(NOT_FOUND, "포인트 조회에 실패 했습니다.")
        ;

        private final HttpStatus status;
        private final String msg;
    }

    public PointException(PointExceptionConst pointExceptionConst) {
        super(pointExceptionConst.getStatus(), pointExceptionConst.getMsg());
    }
}
