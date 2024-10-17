package com.hhplus.task.concert.infra.concert.repository;

import com.hhplus.task.concert.domain.concert.ConcertScheduleRepository;
import com.hhplus.task.concert.domain.concert.dto.ConcertScheduleInfo;
import com.hhplus.task.concert.domain.concert.exception.ConcertScheduleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.hhplus.task.concert.domain.concert.exception.ConcertScheduleException.ConcertScheduleExceptionConst.*;

@Repository
@RequiredArgsConstructor
public class ConcertScheduleRepositoryImpl implements ConcertScheduleRepository {

    private final ConcertScheduleJpaRepository concertScheduleJpaRepository;

    @Override
    public ConcertScheduleInfo findById(Long scheduleId) {
        return concertScheduleJpaRepository.findById(scheduleId)
                                           .orElseThrow(() -> { throw new ConcertScheduleException(SCHEDULE_NOT_AVAILABLE); })
                                           .toInfo();
    }
}
