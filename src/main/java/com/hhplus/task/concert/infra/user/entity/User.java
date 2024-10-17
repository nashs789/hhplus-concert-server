package com.hhplus.task.concert.infra.user.entity;

import com.hhplus.task.concert.domain.user.dto.UserInfo;
import com.hhplus.task.concert.infra.common.entity.Timestamp;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@Builder
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    public UserInfo toInfo() {
        return UserInfo.builder()
                       .id(id)
                       .name(name)
                       .build();
    }

    public static User toEntity(UserInfo userInfo) {
        return User.builder()
                   .id(userInfo.getId())
                   .name(userInfo.getName())
                   .build();
    }
}
