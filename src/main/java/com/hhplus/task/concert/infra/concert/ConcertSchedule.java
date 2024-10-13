package com.hhplus.task.concert.infra.concert;

import com.hhplus.task.concert.infra.common.entity.Timestamp;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@Table(name = "concert")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ConcertSchedule extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "concert_id", nullable = false)
    private Concert concert;

    @Column(nullable = false)
    private Integer capacity;

    @Column(name = "reservation_count", nullable = false)
    private Integer reservationCount;

    @Column(nullable = false)
    private Integer price;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;
}
