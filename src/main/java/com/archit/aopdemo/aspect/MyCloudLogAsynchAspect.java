package com.archit.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyCloudLogAsynchAspect {

    @Before("com.archit.aopdemo.aspect.CommonAopPointcutExpressions" +
            ".forDaoPackageNoGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("\n====>>>> logging to cloud in asynch fashion");
    }
}
