package com.hhplus.task.concert.infra.queue.repository;

import com.hhplus.task.concert.infra.queue.entity.WaitingQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueJpaRepository extends JpaRepository<WaitingQueue, String> {
}
