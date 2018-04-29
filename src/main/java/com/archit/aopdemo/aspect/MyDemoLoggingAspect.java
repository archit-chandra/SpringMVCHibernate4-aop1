package com.archit.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    /**
     * execution pointcut
     * execution (modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
     * ? => optional
     * pattern can use wildcards
     * <p>
     * Parameter pattern wildcards
     * 1. ()   -> method with no parameter
     * 2. (*)  -> method with one argument of any type
     * 3. (..) -> method with 0 or more argument of any type
     */

    // declaring pointcut
    @Pointcut("execution(* com.archit.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {
    }


    // add all advices for logging

    // @Before advice : pointcut expression : match method in a package
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====>>>> executing @Before advice on addAccount" +
                "()");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n====>>>> performing API analytics");
    }
}