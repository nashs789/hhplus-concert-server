package com.hhplus.task.concert.domain.common.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ExceptionInfo {
    private HttpStatus status;
    private String msg;
}
