package com.hhplus.task.concert.infra.user.repository;

import com.hhplus.task.concert.domain.user.PointRepository;
import com.hhplus.task.concert.domain.user.dto.PointInfo;
import com.hhplus.task.concert.domain.user.exception.PointException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.hhplus.task.concert.domain.user.exception.PointException.PointExceptionConst.FAIL_LOAD_POINT;

@Repository
@RequiredArgsConstructor
public class PointRepositoryImpl implements PointRepository {

    private final PointJpaRepository pointJpaRepository;

    @Override
    public PointInfo getPoint(final Long userId) {
        return pointJpaRepository.findById(userId)
                                 .orElseThrow(() -> { throw new PointException(FAIL_LOAD_POINT); })
                                 .toInfo();
    }

    @Override
    public void chargePoint(final Long userId, final Long point) {
        pointJpaRepository.findByIdWithLock(userId);
        pointJpaRepository.chargePoint(userId, point);
    }
}
