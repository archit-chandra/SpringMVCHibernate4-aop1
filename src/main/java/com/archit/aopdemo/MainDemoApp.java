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

        // call the accountDAO business method
        accountDAO.addAccount();

        // calling it again : fun testing
        System.out.println("\nLets do it again");
        accountDAO.addAccount();

        // call the membershipDAO business method
        membershipDAO.addAccount();

        // close the context
        context.close();
    }
}
