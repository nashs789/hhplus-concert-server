package com.hhplus.task.concert.infra.ticket;

import com.hhplus.task.concert.infra.ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketJpaRepository extends JpaRepository<Ticket, Long> {
}
