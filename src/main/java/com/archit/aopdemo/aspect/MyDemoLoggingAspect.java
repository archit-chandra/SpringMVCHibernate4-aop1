package com.archit.aopdemo.aspect;

import com.archit.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

        // post-process the data (modifying data)
        convertAccountNamesToUpperCase(result);

        System.out.println("\n====>>>> result is : " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account : result) {
            String upperName = account.getName().toUpperCase();
            account.setName(upperName);
        }
    }

    // @AfterThrowing advice on findAccounts method
    @AfterThrowing(
            pointcut = "execution(* com.archit.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint,
                                                Throwable theExc) {

        // print the method that is being advised
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> executing @AfterThrowing on method : " + method);

        // log the exception
        System.out.println("\n====>>>> The exception is : " + theExc);
    }

    /**
     * @After (finally) will always run regardless of success or exception of
     * that method
     * @After will execute before @AfterThrowing advice
     * @After does not have access to the exception (independent of exception or success)
     */
    // @After advice on findAccounts method
    @After("execution(* com.archit.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

        // print the method that is being advised
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> executing @After (finally) on method :" + method);
    }

    /**
     * @Around advice runs before and after method execution
     * @Around = @Before + @After + more fine-grained
     * @Around advice can swallow the exception i.e. exception won't be propagated back to main application
     */
    @Around("execution(* com.archit.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {

        // print the method that is being advised
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> executing @Around advice on method :" + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // execute the method
        Object result = proceedingJoinPoint.proceed();

        //get end timestamp
        long end = System.currentTimeMillis();

        // compute the duration & display it
        long duration = end - begin;
        System.out.println("\n====>>>> duration : " + duration / 1000.0 + "seconds");
        return result;
    }


}