package com.hhplus.task.concert.infra.ticket.entity;

import com.hhplus.task.concert.infra.common.entity.Timestamp;
import com.hhplus.task.concert.infra.concert.entity.ConcertSchedule;
import com.hhplus.task.concert.infra.seat.entity.Seat;
import com.hhplus.task.concert.infra.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@Table(name = "ticket")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Ticket extends Timestamp {

    enum TicketStatus {
        PROGRESS, CANCELED, PENDING, RESERVED, USED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "concert_schedule_id", nullable = false)
    private ConcertSchedule concertSchedule;
}
