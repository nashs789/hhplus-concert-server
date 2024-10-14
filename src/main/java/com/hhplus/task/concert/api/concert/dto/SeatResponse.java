package com.hhplus.task.concert.api.concert.dto;

import com.hhplus.task.concert.infra.concert.entity.ConcertSchedule;
import com.hhplus.task.concert.infra.concert.entity.Seat;
import com.hhplus.task.concert.infra.user.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SeatResponse {
    private Long id;
    private ConcertSchedule concertSchedule;
    private User user;
    private Seat.SeatStatus status;
}
