package com.hhplus.task.concert.infra.concert.entity;

import com.hhplus.task.concert.domain.dto.ConcertInfo;
import com.hhplus.task.concert.infra.common.entity.Timestamp;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@Table(name = "concert")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Concert extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String singer;

    @ToString.Exclude
    @OneToMany(mappedBy = "concert", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConcertSchedule> schedules = new ArrayList<>();

    public ConcertInfo toConcertInfo() {
        return ConcertInfo.builder()
                          .id(id)
                          .name(name)
                          .singer(singer)
                          .concertSchedule(schedules)
                          .build();
    }
}
