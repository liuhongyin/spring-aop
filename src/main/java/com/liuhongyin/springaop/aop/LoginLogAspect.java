package com.liuhongyin.springaop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author marcot
 * @since 11/10/19
 */
@Aspect
@Component
@Slf4j
public class LoginLogAspect {

    @Autowired
    private HttpServletRequest request;

    @Pointcut("execution(public * com.liuhongyin.springaop.controller.*Controller.*(..))")
    public void loginLog() {
    }

    @Before("loginLog()")
    public void beforeAdvice(JoinPoint joinPoinAt) {
        log.info("beforeAdvice start");
        log.info("requestURL,{}", request.getRequestURL());
        log.info("remoteIP,{}", request.getRemoteAddr());
        log.info("params,{}", Arrays.toString(joinPoinAt.getArgs()));
        log.info("beforeAdvice end");
    }

    @Around("loginLog()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("aroundAdvice start");
        Object proceed = proceedingJoinPoint.proceed();
        log.info("aroundAdvice return, {}", proceed);
        log.info("aroundAdvice end");
        return proceed;
    }

    @AfterReturning(value = "loginLog()", returning = "obj")
    public void afterReturning(JoinPoint joinPoint, Object obj) {
        log.info("afterReturning,{}", obj);
    }

    @AfterThrowing(value = "loginLog()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        log.info("exception", exception);
    }

    @After(value = "loginLog()")
    public void after(JoinPoint joinPoint) {
        log.info("after start");
        // TODO
        log.info("after end");
    }

}
