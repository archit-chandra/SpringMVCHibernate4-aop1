package com.archit.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // add all advices for logging

    // @Before advice
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====>>>> executing @Before advice on addAccount" +
                "()");
    }
}
