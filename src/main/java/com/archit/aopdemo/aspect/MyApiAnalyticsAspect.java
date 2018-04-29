package com.archit.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyApiAnalyticsAspect {

    @Before("com.archit.aopdemo.aspect.CommonAopPointcutExpressions" +
            ".forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n====>>>> performing API analytics");
    }
}
