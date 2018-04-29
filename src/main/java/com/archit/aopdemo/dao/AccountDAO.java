package com.archit.aopdemo.dao;

import com.archit.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    /*public void addAccount() {
        System.out.println(getClass() + " : doing my DB work - adding an account");
    }*/

    /*public void addAccount(Account account) {
        System.out.println(getClass() + " : doing my DB work - adding an " +
                "account with Account parameter");
    }*/

    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " : doing my DB work - adding an " +
                "account with Account parameter + vipFlag");
    }
}
