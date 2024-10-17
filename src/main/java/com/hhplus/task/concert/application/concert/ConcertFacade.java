package com.hhplus.task.concert.application.concert;

import com.hhplus.task.concert.api.concert.dto.ConcertResponse;
import com.hhplus.task.concert.api.concert.dto.SeatResponse;
import com.hhplus.task.concert.api.payment.dto.PaymentResponse;
import com.hhplus.task.concert.domain.concert.ConcertService;
import com.hhplus.task.concert.domain.concert.dto.ConcertInfo;
import com.hhplus.task.concert.domain.concert.dto.SeatInfo;
import com.hhplus.task.concert.domain.payment.PaymentService;
import com.hhplus.task.concert.domain.ticket.TicketService;
import com.hhplus.task.concert.domain.ticket.dto.TicketInfo;
import com.hhplus.task.concert.domain.user.UserService;
import com.hhplus.task.concert.domain.user.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ConcertFacade {

    private final ConcertService concertService;
    private final UserService userService;
    private final TicketService ticketService;
    private final PaymentService paymentService;

    public List<ConcertResponse> getAllConcerts() {
        return concertService.getAllConcerts()
                             .stream()
                             .map(ConcertInfo::toResponse)
                             .collect(Collectors.toList());
    }

    public List<SeatResponse> getAllSeats(Long scheduleId) {
        return concertService.getAllSeats(scheduleId)
                             .stream()
                             .map(SeatInfo::toResponse)
                             .collect(Collectors.toList());
    }

    @Transactional
    public PaymentResponse createSeatReservation(Long userId, Long scheduleId, Long seatId) {
        SeatInfo seatInfo = concertService.getSeat(scheduleId, seatId);
        UserInfo userInfo = userService.getUser(userId);
        TicketInfo ticketInfo = ticketService.createTicket(userInfo, seatInfo);

        concertService.updateSeat(seatInfo, userInfo);

        return paymentService.createPayment(userInfo, ticketInfo).toResponse();
    }
}
