package com.hhplus.task.concert.infra.point.entity;

import com.hhplus.task.concert.infra.common.entity.Timestamp;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@Table(name = "point_history")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PointHistory extends Timestamp {

    enum PointUseType {
        USE, CHARGE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "point_id", nullable = false)
    private Point point;

    @Enumerated(EnumType.STRING)
    private PointUseType type;

    @Column(nullable = false)
    private Integer amount;

    @Column(name = "after_amount", nullable = false)
    private Integer afterAmount;
}
