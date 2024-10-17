package com.hhplus.task.concert.domain.user;

import com.hhplus.task.concert.domain.user.dto.PointInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointRepository pointRepository;

    public PointInfo getPoint(Long userId) {
        return pointRepository.getPoint(userId);
    }
}
