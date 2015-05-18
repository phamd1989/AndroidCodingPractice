package com.sample.duncapham.lifelockcodingchallenge.utils;

import com.sample.duncapham.lifelockcodingchallenge.models.Account;
import com.sample.duncapham.lifelockcodingchallenge.models.Feature;
import com.sample.duncapham.lifelockcodingchallenge.models.Transaction;

import java.util.Random;

/**
 * Created by duncapham on 5/17/15.
 */
public class GenerateData {

    private static final String ACCOUNT_NAME1 = "Wells Fargo Checking 7395";
    private static final String ACCOUNT_NAME2 = "Wells Fargo Savings 6392";
    private static final String ACCOUNT_NAME3 = "Captial One Visa 1933";
    private static final String ACCOUNT_NAME4 = "American Express 9576";
    private static final String[] accounts = new String[] {ACCOUNT_NAME1, ACCOUNT_NAME2, ACCOUNT_NAME3, ACCOUNT_NAME4};
    private static final String[] merchants = new String[] {"Mama Mia", "Tacobell", "Subway", "MicroNet Inc", "AT&T U-verse", "Costco", "Crate & Barrel", "Wells Fargo Bank"};

    public static void generateFeatureData() {
        Feature.addFeature("LifeLock Protection",
                Feature.Menu.PROTECTION.ordinal(),
                "Live freely in an always connected world");
        Feature.addFeature("LifeLock Protection 2",
                Feature.Menu.PROTECTION.ordinal(),
                "Live freely in an always connected world");
        Feature.addFeature("Financial Activity",
                Feature.Menu.FINANCIAL_ACTIVITY.ordinal(),
                "Account Transactions");
    }

    public static void generateAccountData() {
        Account.addAccount(ACCOUNT_NAME1, "9358.27");
        Account.addAccount(ACCOUNT_NAME2, "15386.08");
        Account.addAccount(ACCOUNT_NAME3, "-358.27");
        Account.addAccount(ACCOUNT_NAME4, "482.09");
    }

    public static void generateTransactionData() {
        for (int i=0; i<20; i++) {
            int j = randInt(accounts.length);
            Account account = Account.getAccount(accounts[j]);
            j = randInt(merchants.length);
            String merchant = merchants[j];
            Transaction.addTransaction(Double.toString(randDouble(-5000,5000)),
                                       "Fri Dec 19, 2014",
                                       account,
                                       merchant,
                                       "General");
        }
    }

    public static double randDouble(int min, int max) {
        Random rand = new Random();
        double randomNum = rand.nextDouble() * (max - min + 1) + min;
        return randomNum;
    }

    public static int randInt(int n) {
        Random rand = new Random();
        return rand.nextInt(n);
    }
}
