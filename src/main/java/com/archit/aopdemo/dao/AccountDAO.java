package com.archit.aopdemo.dao;

import com.archit.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " : doing my DB work - adding an " +
                "account with Account parameter + vipFlag");
    }

    public boolean doWork() {
        System.out.println(getClass() + " : doWork()");
        return false;
    }

    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<Account>();
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");
        accounts.add(temp1);
        accounts.add(temp2);
        accounts.add(temp3);
        return accounts;
    }

    public String getName() {
        System.out.println(getClass() + " : in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " : in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " : in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " : in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
