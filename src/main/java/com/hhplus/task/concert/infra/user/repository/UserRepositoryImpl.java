package com.hhplus.task.concert.infra.user.repository;

import com.hhplus.task.concert.domain.user.UserRepository;
import com.hhplus.task.concert.domain.user.dto.UserInfo;
import com.hhplus.task.concert.domain.user.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.hhplus.task.concert.domain.user.exception.UserException.UserExceptionConst.*;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserInfo findById(Long userId) {
        return userJpaRepository.findById(userId)
                                .orElseThrow(() -> { throw new UserException(USER_NOT_VALID); })
                                .toInfo();
    }
}
