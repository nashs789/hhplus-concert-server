package com.hhplus.task.concert.domain.concert;

import com.hhplus.task.concert.domain.concert.dto.ConcertInfo;
import com.hhplus.task.concert.domain.concert.dto.ConcertScheduleInfo;
import com.hhplus.task.concert.domain.concert.dto.SeatInfo;
import com.hhplus.task.concert.domain.user.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConcertService {

    private final ConcertRepository concertRepository;
    private final ConcertScheduleRepository concertScheduleRepository;
    private final SeatRepository seatRepository;

    public ConcertScheduleInfo getSchedule(Long scheduleId) {
        return concertScheduleRepository.findById(scheduleId);
    }

    public List<ConcertInfo> getAllConcerts() {
        return concertRepository.findAvailableConcerts();
    }

    public List<SeatInfo> getAllSeats(Long scheduleId) {
        return seatRepository.findAllSeatsByScheduleId(scheduleId);
    }

    public SeatInfo getSeat(Long scheduleId, Long seatId) {
        return seatRepository.findById(scheduleId, seatId);
    }

    public void updateSeat(SeatInfo seatInfo, UserInfo userInfo) {
        seatRepository.updateSeat(seatInfo, userInfo);
    }
}
