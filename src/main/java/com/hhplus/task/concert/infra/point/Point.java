package com.hhplus.task.concert.infra.point;

import com.hhplus.task.concert.infra.common.entity.Timestamp;
import com.hhplus.task.concert.infra.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@Table(name = "point")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Point extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Integer point;
}
