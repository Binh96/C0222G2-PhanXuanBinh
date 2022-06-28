package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int count =0;

    @AfterReturning(pointcut = "execution(public * com.controller.BookController.*(..))")
    public void log(JoinPoint joinPoint){
        count++;
        String name = joinPoint.getSignature().getName();
        System.out.println("Chức năng vừa thực hiện xong: "+ name);
        System.out.println("Lượng người vừa ghé thăm thư viện"+ count);
    }
}
