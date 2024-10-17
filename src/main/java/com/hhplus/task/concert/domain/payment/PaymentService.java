package com.hhplus.task.concert.domain.payment;

import com.hhplus.task.concert.domain.payment.dto.PaymentInfo;
import com.hhplus.task.concert.domain.ticket.dto.TicketInfo;
import com.hhplus.task.concert.domain.user.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentInfo createPayment(UserInfo userInfo, TicketInfo ticketInfo) {
        return paymentRepository.createPayment(userInfo, ticketInfo);
    }
}
