package com.hhplus.task.concert.api.seat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/seat/")
public class SeatController {

    @GetMapping("{scheduleId}")
    public ResponseEntity getAllSeats(@PathVariable("scheduleId") String scheduleId) {
        return null;
    }

    @PostMapping("reservation")
    public ResponseEntity createReservation() {
        return null;
    }
}
