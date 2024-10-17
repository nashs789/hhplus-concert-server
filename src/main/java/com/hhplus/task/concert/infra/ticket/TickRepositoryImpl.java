package com.hhplus.task.concert.infra.ticket;

import com.hhplus.task.concert.domain.concert.dto.SeatInfo;
import com.hhplus.task.concert.domain.ticket.TicketRepository;
import com.hhplus.task.concert.domain.ticket.dto.TicketInfo;
import com.hhplus.task.concert.domain.user.dto.UserInfo;
import com.hhplus.task.concert.infra.concert.entity.Seat;
import com.hhplus.task.concert.infra.ticket.entity.Ticket;
import com.hhplus.task.concert.infra.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.hhplus.task.concert.infra.ticket.entity.Ticket.TicketStatus.*;

@Repository
@RequiredArgsConstructor
public class TickRepositoryImpl implements TicketRepository {

    private final TicketJpaRepository ticketJpaRepository;

    @Override
    public TicketInfo createTicket(UserInfo userInfo, SeatInfo seatInfo) {
        User user = User.toEntity(userInfo);
        Seat seat = Seat.toEntity(seatInfo);
        Ticket ticket = Ticket.builder()
                              .user(user)
                              .seat(seat)
                              .status(PROGRESS)
                              .build();

        return ticketJpaRepository.save(ticket).toInfo();
    }
}
