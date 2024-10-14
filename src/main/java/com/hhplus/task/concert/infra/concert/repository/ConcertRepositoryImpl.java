package com.hhplus.task.concert.infra.concert.repository;

import com.hhplus.task.concert.domain.concert.ConcertRepository;
import com.hhplus.task.concert.domain.dto.ConcertInfo;
import com.hhplus.task.concert.infra.concert.entity.Concert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ConcertRepositoryImpl implements ConcertRepository {

    private final ConcertJpaRepository concertRepository;

    @Override
    public List<ConcertInfo> findAvailableConcerts() {
        return concertRepository.findAvailableConcerts(LocalDateTime.now())
                                .stream()
                                .map(Concert::toInfo)
                                .collect(Collectors.toList());
    }
}
