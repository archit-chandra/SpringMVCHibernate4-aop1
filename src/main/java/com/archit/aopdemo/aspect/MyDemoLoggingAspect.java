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

    // declaring pointcut(s)
    @Pointcut("execution(* com.archit.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    // create pointcut for getter methods
    @Pointcut("execution(* com.archit.aopdemo.dao.*.get*(..))")
    private void getter() {
    }

    // create pointcut for setter methods
    @Pointcut("execution(* com.archit.aopdemo.dao.*.set*(..))")
    private void setter() {
    }

    // create pointcut include package ... excude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {
    }


    // add all advices for logging

    // @Before advice : pointcut expression : match method in a package
    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====>>>> executing @Before advice on method");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n====>>>> performing API analytics");
    }
}