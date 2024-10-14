package com.hhplus.task.concert.domain.concert;

import com.hhplus.task.concert.domain.dto.ConcertInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConcertService {

    private final ConcertRepository concertRepository;

    public List<ConcertInfo> getAllConcerts() {
        return concertRepository.findAvailableConcerts();
    }
}
