package main;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Aspect
public class SecurityAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class);

    @Around("execution(* main.CommentPushNotificationProxy.sendComment(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        //Get caught method name
        String methodName = joinPoint.getSignature().getName();
        //Get caught method parameters
        Object[] arguments = joinPoint.getArgs();
        logger.info("Method " + methodName + " with parameters "
                + Arrays.asList(arguments) + " will execute");
        Comment comment = new Comment();
        comment.setText("Text changed by aspect method");
        //Change arguments in caught method
        Object [] newArguments = {comment};
        //Call caught method
        Object returnedByMethod = joinPoint.proceed(newArguments);
        logger.info("Method executed and returned " + returnedByMethod);
        //Return caught method result but in this project we don`t use this
        return returnedByMethod;
    }
}
