package com.hhplus.task.concert.domain.payment;

import com.hhplus.task.concert.domain.payment.dto.PaymentInfo;
import com.hhplus.task.concert.domain.ticket.dto.TicketInfo;
import com.hhplus.task.concert.domain.user.dto.UserInfo;

public interface PaymentRepository {

    PaymentInfo createPayment(UserInfo userInfo, TicketInfo ticketInfo);
}
