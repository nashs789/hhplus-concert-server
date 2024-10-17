package com.hhplus.task.concert.domain.user;

import com.hhplus.task.concert.domain.user.dto.PointInfo;

public interface PointRepository {
    PointInfo getPoint(Long userId);
    void chargePoint(Long userId, Long point);
}
