package com.sample.duncapham.lifelockcodingchallenge.utils;

import com.sample.duncapham.lifelockcodingchallenge.models.Feature;

/**
 * Created by duncapham on 5/17/15.
 */
public class GenerateData {

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
}
