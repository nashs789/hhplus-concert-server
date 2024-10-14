package com.hhplus.task.concert.domain.queue.dto;

import com.hhplus.task.concert.api.queue.dto.QueueResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.hhplus.task.concert.infra.queue.entity.WaitingQueue.TokenStatus;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class WaitingQueueInfo {
    private String id;
    private Long userId;
    private TokenStatus status;
    private LocalDateTime activeTime;

    public QueueResponse toResponse() {
        return QueueResponse.builder()
                            .id(id)
                            .userId(userId)
                            .status(status)
                            .activeTime(activeTime)
                            .build();
    }
}
