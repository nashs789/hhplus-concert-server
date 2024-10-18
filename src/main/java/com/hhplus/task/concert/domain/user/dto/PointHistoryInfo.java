package com.hhplus.task.concert.domain.user.dto;

import com.hhplus.task.concert.api.user.dto.PointHistoryResponse;
import com.hhplus.task.concert.infra.user.entity.Point;
import com.hhplus.task.concert.infra.user.entity.PointHistory.PointUseType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PointHistoryInfo {
    private Long id;
    private Point point;
    private PointUseType type;
    private Integer amount;
    private Integer afterAmount;

    public PointHistoryResponse toResponse() {
        return PointHistoryResponse.builder()
                                   .id(id)
                                   .point(point)
                                   .type(type)
                                   .amount(amount)
                                   .afterAmount(afterAmount)
                                   .build();
    }
}
