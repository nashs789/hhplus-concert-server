package com.hhplus.task.concert.infra.queue.repository;

import com.hhplus.task.concert.infra.queue.entity.WaitingQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QueueJpaRepository extends JpaRepository<WaitingQueue, String> {

    // TOKEN 만료된 토큰에 대한 조건을 추가 해야 할듯? (시간, 상태)
    Optional<WaitingQueue> findById(String queueId);
}
