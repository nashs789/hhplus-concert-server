package com.hhplus.task.concert.domain.ticket.dto;

import com.hhplus.task.concert.infra.concert.entity.Seat;
import com.hhplus.task.concert.infra.ticket.entity.Ticket.TicketStatus;
import com.hhplus.task.concert.infra.user.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class TicketInfo {
    private Long id;
    private User user;
    private Seat seat;
    private TicketStatus status;
}
