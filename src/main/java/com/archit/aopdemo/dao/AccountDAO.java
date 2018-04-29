package com.archit.aopdemo.dao;

import com.archit.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " : doing my DB work - adding an " +
                "account with Account parameter + vipFlag");
    }

    public boolean doWork() {
        System.out.println(getClass() + " : doWork()");
        return false;
    }
}
