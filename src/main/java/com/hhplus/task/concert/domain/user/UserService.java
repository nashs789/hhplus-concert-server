package com.hhplus.task.concert.domain.user;

import com.hhplus.task.concert.domain.user.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserInfo getUser(Long userId) {
        return userRepository.findById(userId);
    }
}
