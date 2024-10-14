package com.hhplus.task.concert.domain.dto;

import com.hhplus.task.concert.infra.concert.entity.ConcertSchedule;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ConcertInfo {
    private Long id;
    private String name;
    private String singer;
    private List<ConcertSchedule> concertSchedule;
}
