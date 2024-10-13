package com.hhplus.task.concert.infra.seat;

import com.hhplus.task.concert.infra.common.entity.Timestamp;
import com.hhplus.task.concert.infra.concert.ConcertSchedule;
import com.hhplus.task.concert.infra.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@Table(name = "seat")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Seat extends Timestamp {

    enum SeatStatus{
        TAKEN, NOT_TAKEN;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "concert_schedule_id", nullable = false)
    private ConcertSchedule concertSchedule;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;
}
