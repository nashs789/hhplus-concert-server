package com.hhplus.task.concert.infra.queue.repository;

import com.hhplus.task.concert.api.queue.dto.QueueResponse;
import com.hhplus.task.concert.domain.queue.dto.WaitingQueueInfo;
import com.hhplus.task.concert.domain.queue.exception.QueueException;
import com.hhplus.task.concert.domain.queue.repository.QueueRepository;
import com.hhplus.task.concert.infra.queue.entity.WaitingQueue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.hhplus.task.concert.domain.queue.exception.QueueException.QueueExceptionConst.*;
import static com.hhplus.task.concert.infra.queue.entity.WaitingQueue.TokenStatus.*;

@Repository
@RequiredArgsConstructor
public class QueueRepositoryImpl implements QueueRepository {

    private final QueueJpaRepository queueJpaRepository;

    @Override
    public WaitingQueueInfo createToken(Long userId) {
        WaitingQueue savedToken = queueJpaRepository.save(WaitingQueue.builder()
                                                                      .userId(userId)
                                                                      .status(WAIT)
                                                                      .build());
        return savedToken.toInfo();
    }

    @Override
    public WaitingQueueInfo findByQueueId(String queueId) {
        return queueJpaRepository.findById(queueId)
                                 .orElseThrow(() -> { throw new QueueException(TOKEN_NOT_FOUND); })
                                 .toInfo();
    }
}
