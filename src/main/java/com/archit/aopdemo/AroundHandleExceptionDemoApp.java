package com.archit.aopdemo;

import com.archit.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {

    private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {

        // read spring config file
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService fortuneService = context.getBean
                ("trafficFortuneService", TrafficFortuneService.class);

        // call the method of bean
        logger.info("\nMain Program: AroundDemoApp");
        logger.info("Calling getFortune");

        boolean tripWire = true;
        String data = fortuneService.getFortune(tripWire);
        logger.info("\nMy fortune is : " + data);
        logger.info("Finished");

        // close the context
        context.close();
    }
}
