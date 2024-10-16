package com.hhplus.task.concert.domain.concert;

import com.hhplus.task.concert.domain.concert.dto.ConcertInfo;

import java.util.List;

public interface ConcertRepository {

    List<ConcertInfo> findAvailableConcerts();

}
