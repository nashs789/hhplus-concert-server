package com.hhplus.task.concert.domain.queue.repository;

import com.hhplus.task.concert.domain.queue.dto.WaitingQueueInfo;

public interface QueueRepository {
    WaitingQueueInfo createToken(Long userId);
}
