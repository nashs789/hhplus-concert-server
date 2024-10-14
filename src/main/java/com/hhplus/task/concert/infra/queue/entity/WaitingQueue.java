package com.hhplus.task.concert.infra.queue.entity;

import com.hhplus.task.concert.domain.queue.dto.WaitingQueueInfo;
import com.hhplus.task.concert.infra.common.entity.Timestamp;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@Builder
@Table(name = "waiting_queue")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class WaitingQueue extends Timestamp {

    public enum TokenStatus {
        WAIT, EXPIRED, RESERVED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "user_id")
    private Long userId;

    @Enumerated(EnumType.STRING)
    private TokenStatus status;

    @Column(name = "active_time")
    private LocalDateTime activeTime;

    public WaitingQueueInfo toInfo() {
        return WaitingQueueInfo.builder()
                               .id(id)
                               .userId(userId)
                               .status(status)
                               .activeTime(activeTime)
                               .build();
    }
}
