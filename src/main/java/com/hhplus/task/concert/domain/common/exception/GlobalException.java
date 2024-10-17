package com.hhplus.task.concert.domain.common.exception;

import com.hhplus.task.concert.domain.common.dto.ExceptionInfo;
import com.hhplus.task.concert.domain.concert.exception.ConcertScheduleException;
import com.hhplus.task.concert.domain.concert.exception.SeatException;
import com.hhplus.task.concert.domain.queue.exception.QueueException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handleException(Exception e) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new RuntimeException("에러가 발생 했습니다."));
    }

    @ExceptionHandler(value = QueueException.class)
    public ResponseEntity<ExceptionInfo> handleException(QueueException e) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                             .body(toExceptionInfo(e));
    }

    @ExceptionHandler(value = SeatException.class)
    public ResponseEntity<ExceptionInfo> handleException(SeatException e) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                             .body(toExceptionInfo(e));
    }

    @ExceptionHandler(value = ConcertScheduleException.class)
    public ResponseEntity<ExceptionInfo> handleException(ConcertScheduleException e) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                             .body(toExceptionInfo(e));
    }

    private ExceptionInfo toExceptionInfo(DomainException e) {
        return ExceptionInfo.builder()
                            .status(e.getStatus())
                            .msg(e.getMessage())
                            .build();
    }
}
