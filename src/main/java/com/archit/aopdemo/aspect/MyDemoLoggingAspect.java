package com.archit.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    /**
     * execution pointcut
     * execution (modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
     * ? => optional
     * pattern can use wildcards
     */

    // add all advices for logging

    // @Before advice : pointcut expression : match on any class method
    /*@Before("execution(public void addAccount())")*/

    // @Before advice : pointcut expression : match on specific class method
    /*@Before("execution(public void com.archit.aopdemo.dao.AccountDAO" +
            ".addAccount())")*/

    // @Before advice : pointcut expression : match on any class with wildcard method
    /*@Before("execution(public void add*())")*/

    // @Before advice : pointcut expression : match method with any return type
    @Before("execution(* add*())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====>>>> executing @Before advice on addAccount" +
                "()");
    }
}
