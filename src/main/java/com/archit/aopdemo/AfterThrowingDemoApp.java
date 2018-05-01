package com.archit.aopdemo;

import com.archit.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(String[] args) {

        // read spring config file
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call the method to find the accounts
        List<Account> accounts = null;
        try {
            accounts = accountDAO.findAccounts();
        } catch (Exception e) {
            System.out.println("\n\nMain Program: ... caught exception" + e);
        }
        System.out.println("\n\nMain Program: AfterThrowingDemoApp");
        System.out.println("--------------------------------------");
        System.out.println(accounts);
        System.out.println("\n");

        // close the context
        context.close();
    }
}
