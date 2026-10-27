package com.example.employee.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditLoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(AuditLoggingAspect.class);

    @Before("execution(* com.example.employee.service..*(..))")
    public void logServiceCall(JoinPoint joinPoint) {
        logger.info("AUDIT: Calling {} with {} argument(s)",
                joinPoint.getSignature().toShortString(), joinPoint.getArgs().length);
    }

    @AfterReturning("execution(* com.example.employee.service..*(..))")
    public void logServiceSuccess(JoinPoint joinPoint) {
        logger.info("AUDIT: Completed {}", joinPoint.getSignature().toShortString());
    }
}
