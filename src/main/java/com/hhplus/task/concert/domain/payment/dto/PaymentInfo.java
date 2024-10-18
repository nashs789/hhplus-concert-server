package com.hhplus.task.concert.domain.payment.dto;

import com.hhplus.task.concert.api.payment.dto.PaymentResponse;
import com.hhplus.task.concert.infra.payment.entity.Payment.PaymentStatus;
import com.hhplus.task.concert.infra.payment.entity.Payment.PaymentType;
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
public class PaymentInfo {

    private Long id;
    private User user;
    private Ticket ticket;
    private PaymentStatus status;
    private PaymentType type;
    private LocalDateTime paidAt;

    public PaymentResponse toResponse() {
        return PaymentResponse.builder()
                              .id(id)
                              .user(user)
                              .ticket(ticket)
                              .status(status)
                              .type(type)
                              .paidAt(paidAt)
                              .build();
    }
}
