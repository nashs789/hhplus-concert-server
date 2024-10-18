package com.hhplus.task.concert.domain.concert;

import com.hhplus.task.concert.domain.concert.dto.SeatInfo;
import com.hhplus.task.concert.domain.user.dto.UserInfo;

import java.util.List;

public interface SeatRepository {

    List<SeatInfo> findAllSeatsByScheduleId(Long scheduleId);
    SeatInfo findById(Long scheduleId, Long seatId);
    void updateSeat(SeatInfo seatInfo, UserInfo user);
}
