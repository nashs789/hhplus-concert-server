package com.hhplus.task.concert.api.user.dto;

import com.hhplus.task.concert.infra.user.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PointResponse {
    private Long id;
    private User user;
    private Integer point;
}
