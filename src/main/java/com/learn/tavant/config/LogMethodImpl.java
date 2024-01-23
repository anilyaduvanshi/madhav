package com.learn.tavant.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class LogMethodImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogMethodImpl.class);

    @Around("@annotation(LogMethods)")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant startTime = Instant.now();
        Object proceed = joinPoint.proceed();
        Instant endTime = Instant.now();
        Long duration = Duration.between(startTime, endTime).toMillis();
        LOGGER.info(String.format("=== duration %s === method %s === args %s === response -> %s", duration, joinPoint.getSignature(), joinPoint.getKind(), joinPoint.proceed().toString()));
        return proceed;
    }

}
