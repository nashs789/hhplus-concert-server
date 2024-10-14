package com.hhplus.task.concert.application.concert;

import com.hhplus.task.concert.api.concert.dto.ConcertResponse;
import com.hhplus.task.concert.domain.concert.ConcertService;
import com.hhplus.task.concert.domain.dto.ConcertInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ConcertFacade {

    private final ConcertService concertService;

    public List<ConcertResponse> getAllConcerts() {
        return concertService.getAllConcerts()
                             .stream()
                             .map(ConcertInfo::toResponse)
                             .collect(Collectors.toList());
    }
}
