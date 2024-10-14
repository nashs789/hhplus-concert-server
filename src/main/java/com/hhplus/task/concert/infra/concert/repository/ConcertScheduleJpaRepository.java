package com.hhplus.task.concert.infra.concert.repository;

import com.hhplus.task.concert.infra.concert.entity.ConcertSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertScheduleJpaRepository extends JpaRepository<ConcertSchedule, Long> {

}
