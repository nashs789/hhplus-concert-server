package com.hhplus.task.concert.domain.concert.dto;

import com.hhplus.task.concert.api.concert.dto.SeatResponse;
import com.hhplus.task.concert.infra.concert.entity.ConcertSchedule;
import com.hhplus.task.concert.infra.concert.entity.Seat.SeatStatus;
import com.hhplus.task.concert.infra.user.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SeatInfo {

    private Long id;
    private ConcertSchedule concertSchedule;
    private User user;
    private SeatStatus status;

    public SeatResponse toResponse() {
        return SeatResponse.builder()
                           .id(id)
                           .concertSchedule(concertSchedule)
                           .user(user)
                           .status(status)
                           .build();
    }
}
