package com.hhplus.task.concert.infra.concert.repository;

import com.hhplus.task.concert.infra.concert.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatJpaRepository extends JpaRepository<Seat, Long> {

    @Query("""
        SELECT s
          FROM Seat s
         WHERE s.concertSchedule.id = :scheduleId
    """)
    List<Seat> findAllSeatsByScheduleId(@Param("scheduleId") Long scheduleId);
}
