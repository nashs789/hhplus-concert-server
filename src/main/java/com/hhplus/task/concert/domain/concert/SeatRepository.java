package com.hhplus.task.concert.domain.concert;

import com.hhplus.task.concert.domain.dto.SeatInfo;

import java.util.List;

public interface SeatRepository {

    List<SeatInfo> findAllSeatsByScheduleId(Long scheduleId);
}
