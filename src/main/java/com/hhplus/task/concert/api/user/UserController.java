package com.hhplus.task.concert.api.user;

import com.hhplus.task.concert.api.user.dto.PointResponse;
import com.hhplus.task.concert.application.user.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @GetMapping("{userId}/point")
    public PointResponse getPoint(@PathVariable Long userId) {
        return userFacade.getPoint(userId);
    }
}
