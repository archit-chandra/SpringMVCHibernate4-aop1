package com.archit.aopdemo.aspect;

import com.archit.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
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


    // add all advices for logging

    // @Before advice : pointcut expression : match method in a package
    @Before("com.archit.aopdemo.aspect.CommonAopPointcutExpressions" +
            ".forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n====>>>> executing @Before advice on method");

        // display method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint
                .getSignature();
        System.out.println("MethodSignature :" + methodSignature);

        // display method arguments
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
            if (arg instanceof Account) {
                // downcast and print Account specific stuff
                // since not overridden toString here
                Account account = (Account) arg;
                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }
    }

    // @AfterReturning advice on findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.archit.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint,
                                                 List<Account> result) {

        // print the method that is being advised
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> executing @AfterReturning on method : " +
                "" + method);

        // print result of the method call
        System.out.println("\n====>>>> result is : " + result);
    }
}