package com.hhplus.task.concert.domain.common.aspect;

import com.hhplus.task.concert.domain.queue.exception.QueueException;
import com.hhplus.task.concert.domain.queue.QueueRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static com.hhplus.task.concert.domain.queue.exception.QueueException.QueueExceptionConst.*;

@Aspect
@Component
@RequiredArgsConstructor
public class TokenValidationAspect {

    private final QueueRepository queueRepository;

    @Pointcut("@annotation(com.hhplus.task.concert.domain.common.aspect.ValidToken)")
    public void queueControllerMethod() {}

    @Around("queueControllerMethod()")
    public Object validateToken(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String authorization = request.getHeader("Authorization");

        if(StringUtils.isEmpty(authorization)) {
            throw new QueueException(TOKEN_NOT_INCLUDED);
        }

        String token = authorization.split(" ")[1];  // Bearer 문자 제거

        queueRepository.findByQueueId(token);

        return joinPoint.proceed();
    }
}
