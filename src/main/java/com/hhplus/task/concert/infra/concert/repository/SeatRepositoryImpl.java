package com.hhplus.task.concert.infra.concert.repository;

import com.hhplus.task.concert.domain.concert.SeatRepository;
import com.hhplus.task.concert.domain.concert.dto.SeatInfo;
import com.hhplus.task.concert.domain.concert.exception.SeatException;
import com.hhplus.task.concert.domain.user.dto.UserInfo;
import com.hhplus.task.concert.infra.concert.entity.ConcertSchedule;
import com.hhplus.task.concert.infra.concert.entity.Seat;
import com.hhplus.task.concert.infra.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.hhplus.task.concert.domain.concert.exception.SeatException.SeatExceptionConst.SEAT_NOT_AVAILABLE;
import static com.hhplus.task.concert.infra.concert.entity.Seat.SeatStatus.NOT_TAKEN;
import static com.hhplus.task.concert.infra.concert.entity.Seat.SeatStatus.TAKING;

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

    @Override
    public SeatInfo findById(Long scheduleId, Long seatId) {
        return seatJpaRepository.findById(scheduleId, seatId, NOT_TAKEN)
                                .orElseThrow(() -> { throw new SeatException(SEAT_NOT_AVAILABLE); })
                                .toInfo();
    }

    @Override
    public void updateSeat(SeatInfo seatInfo, UserInfo userInfo) {
        User user = User.toEntity(userInfo);

        seatJpaRepository.updateSeat(seatInfo.getId(), TAKING, user);
    }
}
