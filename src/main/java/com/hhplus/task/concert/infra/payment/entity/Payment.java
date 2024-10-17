package com.hhplus.task.concert.infra.payment.entity;

import com.hhplus.task.concert.domain.payment.dto.PaymentInfo;
import com.hhplus.task.concert.infra.common.entity.Timestamp;
import com.hhplus.task.concert.infra.ticket.entity.Ticket;
import com.hhplus.task.concert.infra.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@ToString
@Table(name = "payment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends Timestamp {

    public enum PaymentStatus {
        WAIT, PAYED, CANCEL, REFUND
    }

    public enum PaymentType {
        CASH, CARD
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @Enumerated(EnumType.STRING)
    private PaymentType type;

    @Column
    private LocalDateTime paidAt;

    public PaymentInfo toInfo() {
        return PaymentInfo.builder()
                          .id(id)
                          .user(user)
                          .ticket(ticket)
                          .status(status)
                          .type(type)
                          .paidAt(paidAt)
                          .build();
    }
}
