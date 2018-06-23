package com.archit.aopdemo;

import com.archit.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {

    public static void main(String[] args) {

        // read spring config file
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService fortuneService = context.getBean
                ("trafficFortuneService", TrafficFortuneService.class);

        // call the method of bean
        System.out.println("\nMain Program: AroundDemoApp");
        System.out.println("Calling getFortune");
        String data = fortuneService.getFortune();
        System.out.println("\nMy fortune is : " + data);
        System.out.println("Finished");

        // close the context
        context.close();
    }
}
