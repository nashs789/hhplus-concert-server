package com.hhplus.task.concert.application.concert;

import com.hhplus.task.concert.domain.concert.ConcertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ConcertFacade {

    private final ConcertService concertService;

    public List getAllConcerts() {
        return concertService.getAllConcerts();
    }
}
