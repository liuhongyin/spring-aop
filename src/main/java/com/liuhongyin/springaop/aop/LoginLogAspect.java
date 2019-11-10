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

    /**
     * @ Pointcut这个注解主要用来定义切入点，通过表达式的方式，来告诉Spring,我这个切点要切到什么位置，常用的就是execution去匹配连接点。
     * @ 语法：execution( [方法修饰符(可选)]__返回类型__类路径__方法名__(参数)__[异常模式(可选)] )
     * @ *就是通配符，（..）代表任意多个参数
     */
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
