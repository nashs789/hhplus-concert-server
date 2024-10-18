package com.hhplus.task.concert.domain.user;

import com.hhplus.task.concert.domain.user.dto.PointHistoryInfo;
import com.hhplus.task.concert.domain.user.dto.PointInfo;

public interface PointHistoryRepository {
    PointHistoryInfo savePointHistory(PointInfo userPoint, Integer newPoint);
}
