package com.archit.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // add all advices for logging

    // @Before advice : pointcut expression : match on any class method
    /*@Before("execution(public void addAccount())")*/

    // @Before advice : pointcut expression : match on specific class method
    /*@Before("execution(public void com.archit.aopdemo.dao.AccountDAO" +
            ".addAccount())")*/

    // @Before advice : pointcut expression : match on any class with wildcard method
    @Before("execution(public void add*())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====>>>> executing @Before advice on addAccount" +
                "()");
    }
}
