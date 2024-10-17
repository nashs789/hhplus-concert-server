package com.hhplus.task.concert.application.user;

import com.hhplus.task.concert.api.user.dto.PointResponse;
import com.hhplus.task.concert.domain.user.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final PointService pointService;

    public PointResponse getPoint(final Long userId) {
        return pointService.getPoint(userId).toResponse();
    }

    @Transactional
    public void chargePoint(final Long userId, final Long point) {
        pointService.chargePoint(userId, point);
    }
}
