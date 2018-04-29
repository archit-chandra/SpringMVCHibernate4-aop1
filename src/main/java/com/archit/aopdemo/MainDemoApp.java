package com.archit.aopdemo;

import com.archit.aopdemo.dao.AccountDAO;
import com.archit.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        // read spring config file
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO",
                MembershipDAO.class);

        // call the DAO beans business method(s)
        Account account = new Account();
        accountDAO.addAccount(account, true);
        accountDAO.doWork();

        membershipDAO.addAccount();
        membershipDAO.goToSleep();

        // close the context
        context.close();
    }
}
