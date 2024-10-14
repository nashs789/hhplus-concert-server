package com.hhplus.task.concert.infra.concert.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hhplus.task.concert.infra.common.entity.Timestamp;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@Table(name = "concert_schedule")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ConcertSchedule extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "concert_id", nullable = false)
    @ToString.Exclude
    @JsonIgnore
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
