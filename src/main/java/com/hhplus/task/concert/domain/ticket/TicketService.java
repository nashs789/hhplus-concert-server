package com.hhplus.task.concert.domain.ticket;

import com.hhplus.task.concert.domain.concert.dto.SeatInfo;
import com.hhplus.task.concert.domain.ticket.dto.TicketInfo;
import com.hhplus.task.concert.domain.user.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketInfo createTicket(UserInfo userInfo, SeatInfo seatInfo) {
        return ticketRepository.createTicket(userInfo, seatInfo);
    }
}
