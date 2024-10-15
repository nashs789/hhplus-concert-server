package com.hhplus.task.concert.api.queue.controller;

import com.hhplus.task.concert.api.queue.dto.QueueRequest;
import com.hhplus.task.concert.api.queue.dto.QueueResponse;
import com.hhplus.task.concert.domain.queue.repository.QueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/queue/")
public class QueueController {

    private final QueueService queueService;

    @PostMapping
    public ResponseEntity<QueueResponse> createToken(@RequestBody QueueRequest queueRequest) {
        return ResponseEntity.ok(queueService.createToken(queueRequest.userId()));
    }

    @GetMapping("{queueId}")
    public ResponseEntity<QueueResponse> findByQueueId(@PathVariable("queueId") String queueId) {
        return ResponseEntity.ok(queueService.findByQueueId(queueId));
    }
}
