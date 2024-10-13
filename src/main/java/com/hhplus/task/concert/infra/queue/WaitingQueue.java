package com.hhplus.task.concert.infra.queue;

import com.hhplus.task.concert.infra.common.entity.Timestamp;
import com.hhplus.task.concert.infra.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@Table(name = "waiting_queue")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class WaitingQueue extends Timestamp {

    enum TokenStatus {
        WAIT, EXPIRED, RESERVED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private TokenStatus status;
}
