package main;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class);

    @Around("@annotation(ToLog)")
    public void logging(ProceedingJoinPoint joinPoint) throws Throwable {
        //Get caught method name
        String methodName = joinPoint.getSignature().getName();
        //Get caught method parameters
        Object[] arguments = joinPoint.getArgs();
        logger.info("Method " + methodName + " with parameters "
                + Arrays.asList(arguments) + " will execute");
        joinPoint.proceed();
    }
}
