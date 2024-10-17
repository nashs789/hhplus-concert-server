package com.hhplus.task.concert.infra.user.repository;

import com.hhplus.task.concert.infra.user.entity.PointHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointHistoryJpaRepository extends JpaRepository<PointHistory, Long> {
}
