package com.hhplus.task.concert.infra.payment;

import com.hhplus.task.concert.domain.payment.PaymentRepository;
import com.hhplus.task.concert.domain.payment.dto.PaymentInfo;
import com.hhplus.task.concert.domain.ticket.dto.TicketInfo;
import com.hhplus.task.concert.domain.user.dto.UserInfo;
import com.hhplus.task.concert.infra.payment.entity.Payment;
import com.hhplus.task.concert.infra.payment.entity.Payment.PaymentType;
import com.hhplus.task.concert.infra.ticket.entity.Ticket;
import com.hhplus.task.concert.infra.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.hhplus.task.concert.infra.payment.entity.Payment.PaymentStatus.*;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {

    private final PaymentJpaRepository paymentJpaRepository;

    @Override
    public PaymentInfo createPayment(UserInfo userInfo, TicketInfo ticketInfo) {
        User user = User.toEntity(userInfo);
        Ticket ticket = Ticket.toEntity(ticketInfo);
        Payment payment = Payment.builder()
                                 .user(user)
                                 .ticket(ticket)
                                 .status(WAIT)
                                 .build();

        return paymentJpaRepository.save(payment).toInfo();
    }
}
