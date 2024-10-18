package com.hhplus.task.concert.application.user;

import com.hhplus.task.concert.api.user.dto.PointHistoryResponse;
import com.hhplus.task.concert.api.user.dto.PointResponse;
import com.hhplus.task.concert.domain.user.PointHistoryService;
import com.hhplus.task.concert.domain.user.PointService;
import com.hhplus.task.concert.domain.user.dto.PointInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final PointService pointService;
    private final PointHistoryService pointHistoryService;

    public PointResponse getPoint(final Long userId) {
        return pointService.getPoint(userId).toResponse();
    }

    @Transactional
    public PointHistoryResponse chargePoint(final Long userId, final Long point) {
        PointInfo userPoint = pointService.getPointWithLock(userId);
        Long newPoint = userPoint.getPoint() + point;

        pointService.chargePoint(userId, newPoint);

        return pointHistoryService.savePointHistory(userPoint, newPoint.intValue()).toResponse();
    }
}
