package com.hhplus.task.concert.infra.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Timestamp {

    @JsonIgnore
    @CreatedDate
    @Column(name = "create_at", updatable = false)
    private LocalDateTime createAt;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updateAt;
}
