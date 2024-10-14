package com.hhplus.task.concert.domain.concert;

import com.hhplus.task.concert.domain.dto.ConcertInfo;
import com.hhplus.task.concert.domain.dto.SeatInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConcertService {

    private final ConcertRepository concertRepository;
    private final SeatRepository seatRepository;

    public List<ConcertInfo> getAllConcerts() {
        return concertRepository.findAvailableConcerts();
    }

    public List<SeatInfo> getAllSeats(Long scheduleId) {
        return seatRepository.findAllSeatsByScheduleId(scheduleId);
    }
}
