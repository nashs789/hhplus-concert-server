package com.hhplus.task.concert.api.queue.dto;

import com.hhplus.task.concert.infra.queue.entity.WaitingQueue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class QueueResponse {
    private String id;
    private Long userId;
    private WaitingQueue.TokenStatus status;
    private LocalDateTime activeTime;
}
