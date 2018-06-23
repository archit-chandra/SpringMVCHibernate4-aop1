package com.archit.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {
        System.out.println(getClass() + " : doing stuff - adding membership " +
                "account");
    }

    public void goToSleep() {
        System.out.println(getClass() + " : doing stuff - I am going to sleep" +
                " now ...");
    }
}
