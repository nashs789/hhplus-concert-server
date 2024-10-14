package com.hhplus.task.concert.api.concert.controller;

import com.hhplus.task.concert.api.concert.dto.ConcertResponse;
import com.hhplus.task.concert.api.concert.dto.SeatResponse;
import com.hhplus.task.concert.application.concert.ConcertFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/concert/")
@RequiredArgsConstructor
public class ConcertController {

    private final ConcertFacade concertFacade;

    @GetMapping("concerts")
    public ResponseEntity<List<ConcertResponse>> getAllConcerts() {
        return ResponseEntity.ok(concertFacade.getAllConcerts());
    }

    @PostMapping("reservation")
    public ResponseEntity createConcertReservation() {
        return null;
    }

    @GetMapping("seat/{scheduleId}")
    public ResponseEntity<List<SeatResponse>> getAllSeats(@PathVariable("scheduleId") Long scheduleId) {
        return ResponseEntity.ok(concertFacade.getAllSeats(scheduleId));
    }

    @PostMapping("seat/reservation")
    public ResponseEntity createSeatReservation() {
        return null;
    }
}
