package com.hhplus.task.concert.domain.user;

import com.hhplus.task.concert.domain.user.dto.UserInfo;

public interface UserRepository {
    UserInfo findById(Long userId);
}
