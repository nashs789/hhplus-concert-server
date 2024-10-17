package com.hhplus.task.concert.application.user;

import com.hhplus.task.concert.api.user.dto.PointResponse;
import com.hhplus.task.concert.domain.user.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final PointService pointService;

    public PointResponse getPoint(Long userId) {
        return pointService.getPoint(userId).toResponse();
    }
}
