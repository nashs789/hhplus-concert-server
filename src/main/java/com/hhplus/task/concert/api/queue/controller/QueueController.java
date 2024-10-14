package com.hhplus.task.concert.api.queue.controller;

import com.hhplus.task.concert.api.queue.dto.QueueResponse;
import com.hhplus.task.concert.domain.queue.repository.QueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/queue/")
public class QueueController {

    private final QueueService queueService;

    @PutMapping("{userId}")
    public ResponseEntity<QueueResponse> createToken(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(queueService.createToken(userId));
    }
}
