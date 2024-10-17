package com.hhplus.task.concert.domain.concert;

import com.hhplus.task.concert.domain.concert.dto.ConcertScheduleInfo;

public interface ConcertScheduleRepository {
    ConcertScheduleInfo findById(Long scheduleId);
}
