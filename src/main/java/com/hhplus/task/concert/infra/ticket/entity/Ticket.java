package com.hhplus.task.concert.infra.ticket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hhplus.task.concert.domain.ticket.dto.TicketInfo;
import com.hhplus.task.concert.infra.common.entity.Timestamp;
import com.hhplus.task.concert.infra.concert.entity.ConcertSchedule;
import com.hhplus.task.concert.infra.concert.entity.Seat;
import com.hhplus.task.concert.infra.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@Table(name = "ticket")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Ticket extends Timestamp {

    public enum TicketStatus {
        PROGRESS, CANCELED, PENDING, RESERVED, USED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    public TicketInfo toInfo() {
        return TicketInfo.builder()
                         .id(id)
                         .user(user)
                         .seat(seat)
                         .build();
    }

    public static Ticket toEntity(TicketInfo ticketInfo) {
        return Ticket.builder()
                     .id(ticketInfo.getId())
                     .user(ticketInfo.getUser())
                     .seat(ticketInfo.getSeat())
                     .status(ticketInfo.getStatus())
                     .build();
    }
}
