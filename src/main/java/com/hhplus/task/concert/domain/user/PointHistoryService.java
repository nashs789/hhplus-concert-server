package com.hhplus.task.concert.domain.user;

import com.hhplus.task.concert.domain.user.dto.PointHistoryInfo;
import com.hhplus.task.concert.domain.user.dto.PointInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointHistoryService {

    private final PointHistoryRepository pointHistoryRepository;

    public PointHistoryInfo savePointHistory(PointInfo userPoint, Integer newPoint) {
        return pointHistoryRepository.savePointHistory(userPoint, newPoint);
    }
}
