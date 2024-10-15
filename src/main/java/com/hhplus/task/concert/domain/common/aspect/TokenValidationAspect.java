package com.hhplus.task.concert.domain.common.aspect;

import com.hhplus.task.concert.domain.queue.dto.WaitingQueueInfo;
import com.hhplus.task.concert.domain.queue.repository.QueueRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@RequiredArgsConstructor
public class TokenValidationAspect {

    private final QueueRepository queueRepository;

    @Pointcut("@annotation(com.hhplus.task.concert.domain.common.aspect.TokenCheck)")
    public void queueControllerMethod() {}

    @Around("queueControllerMethod()")
    public Object validateToken(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization").split(" ")[1];  // Bearer 문자 제거

        queueRepository.findByQueueId(token);

        return joinPoint.proceed();
    }
}
