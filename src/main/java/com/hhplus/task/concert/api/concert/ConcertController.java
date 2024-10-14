package com.hhplus.task.concert.api.concert;

import com.hhplus.task.concert.application.concert.ConcertFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/concert/")
@RequiredArgsConstructor
public class ConcertController {

    private final ConcertFacade concertFacade;

    @GetMapping("concerts")
    public ResponseEntity getAllConcerts() {
        return ResponseEntity.ok(concertFacade.getAllConcerts());
    }

    @PostMapping("reservation")
    public ResponseEntity createReservation() {
        return null;
    }
}
