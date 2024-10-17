package com.hhplus.task.concert.infra.user.repository;

import com.hhplus.task.concert.infra.user.entity.Point;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PointJpaRepository extends JpaRepository<Point, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("""
        SELECT p
          FROM Point p
         WHERE p.user.id = :userId
    """)
    Point findByIdWithLock(@Param("userId") Long userId);

    @Modifying
    @Query("""
        UPDATE Point s
           SET s.point = s.point + :point
         WHERE s.user.id = :userId 
    """)
    int chargePoint(@Param("userId") Long userId, @Param("point") Long point);

    @Modifying
    @Query("""
        UPDATE Point s
           SET s.point = :point
         WHERE s.user.id = :userId
    """)
    int usePoint(@Param("userId") Long userId, @Param("point") Long point);
}
