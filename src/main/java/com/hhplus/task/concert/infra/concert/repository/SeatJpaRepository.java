package com.hhplus.task.concert.infra.concert.repository;

import com.hhplus.task.concert.infra.concert.entity.ConcertSchedule;
import com.hhplus.task.concert.infra.concert.entity.Seat;
import com.hhplus.task.concert.infra.concert.entity.Seat.SeatStatus;
import com.hhplus.task.concert.infra.user.entity.User;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatJpaRepository extends JpaRepository<Seat, Long> {

    @Query("""
        SELECT s
          FROM Seat s
         WHERE s.concertSchedule.id = :scheduleId
    """)
    List<Seat> findAllSeatsByScheduleId(@Param("scheduleId") Long scheduleId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("""
        SELECT s
          FROM Seat s
         WHERE s.id = :seatId
           AND s.concertSchedule.id = :scheduleId
           AND s.status = :status
           AND s.user.id IS NULL
    """)
    Optional<Seat> findById(@Param("scheduleId") Long scheduleId, @Param("seatId") Long seatId, @Param("status") SeatStatus status);

    @Modifying
    @Query("""
        UPDATE Seat s
           SET s.user = :user
             , s.status = :status
         WHERE s.id = :seatId
             
    """)
    void updateSeat(@Param("seatId") Long seatId,
                    @Param("status") SeatStatus status,
                    @Param("user") User user);
}
