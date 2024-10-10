package com.hhplus.task.concert.api.point;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/point/")
public class PointController {

    @GetMapping("{userId}")
    public ResponseEntity getUserPoint(@PathVariable Long userId) {
        return null;
    }

    @PutMapping("charge")
    public ResponseEntity chargePoint() {
        return null;
    }

    @PutMapping("spend")
    public ResponseEntity spendPoint() {
        return null;
    }
}
