package com.hhplus.task.concert.domain.user.dto;

import com.hhplus.task.concert.api.user.dto.PointResponse;
import com.hhplus.task.concert.infra.user.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PointInfo {
    private Long id;
    private User user;
    private Integer point;

    public PointResponse toResponse() {
        return PointResponse.builder()
                            .id(id)
                            .user(user)
                            .point(point)
                            .build();
    }
}
