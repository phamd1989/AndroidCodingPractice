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
@Table(name = "tweets")
public class Feature extends Model implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "title")
    private String title;
    @Column(name = "uid", unique = true)
    private long uid;
    @Column(name = "description")
    private String desc;

    public Feature() {
        super();
    }

    public Feature(String title, long uid, String desc) {
        super();
        this.title = title;
        this.uid = uid;
        this.desc = desc;
    }

    public static void addFeature(String title, long uid, String desc) {
        if (getFeature(uid) == null) {
            Feature feature = new Feature(title, uid, desc);
            feature.save();
        }
    }

    public static List<Feature> getAllFeatures() {
        List<Feature> features = new Select().from(Feature.class).execute();
        return features;
    }

    private static Feature getFeature(long uid) {
        return new Select().from(Feature.class).where("uid = ?", uid).executeSingle();
    }

    public String getTitle() {
        return this.title;
    }

    public long getUid() {
        return this.uid;
    }

    public String getDesc() {
        return this.desc;
    }
    public enum Menu{
        IDENTITY_CARD,
        PAYMENT_CARD,
        OTHER_CARD,
        PROTECTION,
        FINANCIAL_ACTIVITY
    }

}
