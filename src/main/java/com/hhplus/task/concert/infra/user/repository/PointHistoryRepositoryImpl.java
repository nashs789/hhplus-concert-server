package com.hhplus.task.concert.infra.user.repository;

import com.hhplus.task.concert.domain.user.PointHistoryRepository;
import com.hhplus.task.concert.domain.user.dto.PointHistoryInfo;
import com.hhplus.task.concert.domain.user.dto.PointInfo;
import com.hhplus.task.concert.infra.user.entity.Point;
import com.hhplus.task.concert.infra.user.entity.PointHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.hhplus.task.concert.infra.user.entity.PointHistory.PointUseType.*;

@Repository
@RequiredArgsConstructor
public class PointHistoryRepositoryImpl implements PointHistoryRepository {

    private final PointHistoryJpaRepository pointHistoryJpaRepository;

    @Override
    public PointHistoryInfo savePointHistory(PointInfo userPoint, Integer newPoint) {
        Point point = Point.toEntity(userPoint);
        PointHistory pointHistory = PointHistory.builder()
                                                .point(point)
                                                .type(USE)
                                                .amount(point.getPoint())
                                                .afterAmount(newPoint)
                                                .build();

        return pointHistoryJpaRepository.save(pointHistory).toInfo();
    }
}
