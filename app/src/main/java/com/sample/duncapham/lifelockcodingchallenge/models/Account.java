package com.sample.duncapham.lifelockcodingchallenge.models;

import java.io.Serializable;
import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

/**
 * Created by duncapham on 5/17/15.
 */
@Table(name = "accounts")
public class Account extends Model implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "name")
    private String name;
    @Column(name = "uid", unique = true)
    private long uid;
    @Column(name = "balance")
    private String balance;

    public Account() {
        super();
    }

    public Account(String name, String balance) {
        super();
        this.name = name;
        this.uid = name.toLowerCase().hashCode();
        this.balance = balance;
    }

    public static void addAccount(String name, String balance) {
        if (getAccount(name) == null) {
            Account account = new Account(name, balance);
            account.save();
        }
    }

    public static List<Account> getAllAccounts() {
        List<Account> accounts = new Select().from(Account.class).execute();
        return accounts;
    }

    public static Account getAccount(String name) {
        long uid = name.toLowerCase().hashCode();
        return new Select().from(Account.class).where("uid = ?", uid).executeSingle();
    }

    public String getName() {
        return name;
    }

    public long getUid() {
        return uid;
    }

    public String getBalance() {
        return balance;
    }
}
