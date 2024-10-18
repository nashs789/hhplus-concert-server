package com.hhplus.task.concert.api.user;

import com.hhplus.task.concert.api.user.dto.PointHistoryResponse;
import com.hhplus.task.concert.api.user.dto.PointRequest;
import com.hhplus.task.concert.api.user.dto.PointResponse;
import com.hhplus.task.concert.application.user.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @GetMapping("{userId}/point")
    public ResponseEntity<PointResponse> getPoint(@PathVariable Long userId) {
        return ResponseEntity.ok(userFacade.getPoint(userId));
    }

    @PutMapping("charge/point")
    public ResponseEntity<PointHistoryResponse> chargePoint(@RequestBody PointRequest pointRequest) {
        return ResponseEntity.ok(userFacade.chargePoint(pointRequest.userId(), pointRequest.point()));
    }
}
