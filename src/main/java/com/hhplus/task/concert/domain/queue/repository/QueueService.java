package com.hhplus.task.concert.domain.queue.repository;

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
}
