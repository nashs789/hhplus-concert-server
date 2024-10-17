package com.hhplus.task.concert.api.user.dto;

import com.hhplus.task.concert.infra.user.entity.Point;
import com.hhplus.task.concert.infra.user.entity.PointHistory;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PointHistoryResponse {
    private Long id;
    private Point point;
    private PointHistory.PointUseType type;
    private Integer amount;
    private Integer afterAmount;
}
