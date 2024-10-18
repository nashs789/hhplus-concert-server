package com.hhplus.task.concert.infra.concert.repository;

import com.hhplus.task.concert.infra.concert.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConcertJpaRepository extends JpaRepository<Concert, Long> {

    @Query("""
        SELECT c
          FROM Concert c
          LEFT OUTER JOIN ConcertSchedule cs
            ON c.id = cs.concert.id
         WHERE cs.startDate <= :now
           AND cs.endDate >= :now
           AND cs.capacity <= cs.reservationCount
    """)
    List<Concert> findAvailableConcerts(@Param("now") LocalDateTime now);
}
