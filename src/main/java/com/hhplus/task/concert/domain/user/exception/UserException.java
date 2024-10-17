package com.hhplus.task.concert.domain.user.exception;

import com.hhplus.task.concert.domain.common.exception.DomainException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class UserException extends DomainException {

    @Getter
    @RequiredArgsConstructor
    public enum UserExceptionConst {
        USER_NOT_VALID(NOT_FOUND, "유효하지 않은 유저 입니다.")
        ;

        private final HttpStatus status;
        private final String msg;
    }

    public UserException(UserExceptionConst userExceptionConst) {
        super(userExceptionConst.getStatus(), userExceptionConst.getMsg());
    }
}
