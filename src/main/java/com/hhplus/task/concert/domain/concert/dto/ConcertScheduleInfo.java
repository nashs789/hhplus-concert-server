package com.hhplus.task.concert.domain.concert.dto;

import com.hhplus.task.concert.infra.concert.entity.Concert;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ConcertScheduleInfo {
    private Long id;
    private Concert concert;
    private Integer capacity;
    private Integer reservationCount;
    private Integer price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
