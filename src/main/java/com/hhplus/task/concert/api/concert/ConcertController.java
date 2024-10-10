package com.hhplus.task.concert.api.concert;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/concert/")
public class ConcertController {

    @GetMapping("concerts")
    public ResponseEntity getAllConcerts() {
        return null;
    }

    @PostMapping("reservation")
    public ResponseEntity createReservation() {
        return null;
    }
}
