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
@Table(name = "transactions")
public class Transaction extends Model implements Serializable{
    private static final long serialVersionUID = 1L;
    @Column(name = "amount")
    private String amount;
    @Column(name = "uid", unique = true)
    private long uid;
    @Column(name = "date")
    private String date;
    @Column(name = "account")
    private Account account;
    @Column(name = "merchant")
    private String merchant;
    @Column(name = "category")
    private String category;

    public Transaction() {
        super();
    }

    public Transaction(String amount, String date, Account account, String merchant, String category) {
        super();
        this.amount = amount;
        this.date = date;
        this.uid = (account.getName() + merchant).toLowerCase().hashCode();
        this.account = account;
        this.merchant = merchant;
        this.category = category;
    }

    public static void addTransaction(String amount, String date, Account account, String merchant, String category) {
        long uid = (amount + account.getName() + merchant).toLowerCase().hashCode();
        if (getTransaction(uid) == null) {
            Transaction transaction = new Transaction(amount, date, account, merchant, category);
            transaction.save();
        }
    }

    public static List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new Select().from(Transaction.class).execute();
        return transactions;
    }

    private static Transaction getTransaction(long uid) {
        return new Select().from(Transaction.class).where("uid = ?", uid).executeSingle();
    }

    public String getAmount() {
        return amount;
    }

    public long getUid() {
        return uid;
    }

    public String getDate() {
        return date;
    }

    public Account getAccount() {
        return account;
    }

    public String getMerchant() {
        return merchant;
    }

    public String getCategory() {
        return category;
    }
}
