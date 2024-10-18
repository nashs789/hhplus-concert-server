package com.hhplus.task.concert.infra.concert.repository;

import com.hhplus.task.concert.infra.concert.entity.ConcertSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConcertScheduleJpaRepository extends JpaRepository<ConcertSchedule, Long> {

    @Query("""
        SELECT cs
          FROM ConcertSchedule cs
         WHERE cs.id = :scheduleId
           AND cs.capacity >= cs.reservationCount
    """)
    Optional<ConcertSchedule> findById(@Param("scheduleId") Long scheduleId);
}
