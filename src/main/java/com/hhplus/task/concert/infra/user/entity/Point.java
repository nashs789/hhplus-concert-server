package com.hhplus.task.concert.infra.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hhplus.task.concert.domain.user.dto.PointInfo;
import com.hhplus.task.concert.infra.common.entity.Timestamp;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "point")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Point extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Integer point;

    public PointInfo toInfo() {
        return PointInfo.builder()
                        .id(id)
                        .user(user)
                        .point(point)
                        .build();
    }
}
