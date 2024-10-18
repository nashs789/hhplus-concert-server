package com.hhplus.task.concert.domain.ticket;

import com.hhplus.task.concert.domain.concert.dto.SeatInfo;
import com.hhplus.task.concert.domain.ticket.dto.TicketInfo;
import com.hhplus.task.concert.domain.user.dto.UserInfo;

public interface TicketRepository {

    TicketInfo createTicket(UserInfo userInfo, SeatInfo seatInfo);
}
