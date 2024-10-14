package com.hhplus.task.concert.infra.concert.repository;

import com.hhplus.task.concert.domain.concert.SeatRepository;
import com.hhplus.task.concert.domain.dto.SeatInfo;
import com.hhplus.task.concert.infra.concert.entity.Seat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class SeatRepositoryImpl implements SeatRepository {

    private final SeatJpaRepository seatJpaRepository;

    @Override
    public List<SeatInfo> findAllSeatsByScheduleId(Long scheduleId) {
        return seatJpaRepository.findAllSeatsByScheduleId(scheduleId)
                                .stream()
                                .map(Seat::toInfo)
                                .collect(Collectors.toList());
    }
}
