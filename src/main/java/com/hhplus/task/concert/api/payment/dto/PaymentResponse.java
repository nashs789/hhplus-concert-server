package com.hhplus.task.concert.api.payment.dto;

import com.hhplus.task.concert.infra.payment.entity.Payment;
import com.hhplus.task.concert.infra.ticket.entity.Ticket;
import com.hhplus.task.concert.infra.user.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentResponse {
    private Long id;
    private User user;
    private Ticket ticket;
    private Payment.PaymentStatus status;
    private Payment.PaymentType type;
    private LocalDateTime paidAt;
}
