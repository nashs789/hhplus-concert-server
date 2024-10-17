package com.hhplus.task.concert.domain.queue;

import com.hhplus.task.concert.domain.queue.dto.WaitingQueueInfo;

public interface QueueRepository {
    WaitingQueueInfo createToken(Long userId);
    WaitingQueueInfo findByQueueId(String queueId);
}
