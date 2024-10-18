package com.hhplus.task.concert.domain.queue;

import com.hhplus.task.concert.api.queue.dto.QueueResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueueService {

    private final QueueRepository queueRepository;

    public QueueResponse createToken(Long userId) {
        return queueRepository.createToken(userId).toResponse();
    }

    public QueueResponse findByQueueId(String queueId) {
        return queueRepository.findByQueueId(queueId).toResponse();
    }
}
