package com.sample.duncapham.lifelockcodingchallenge.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sample.duncapham.lifelockcodingchallenge.R;
import com.sample.duncapham.lifelockcodingchallenge.models.Feature;

import java.util.List;

/**
 * Created by duncapham on 5/17/15.
 */
public class LifeLockFeatureAdapter extends ArrayAdapter<Feature> {

    public LifeLockFeatureAdapter(Context context, List<Feature> features) {
        super(context, 0, features);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Feature feature = getItem(position);
        View view;
        if (convertView == null) {
            LayoutInflater inflator = LayoutInflater.from(getContext());
            view = inflator.inflate(R.layout.feature_item, parent, false);
        } else {
            view = convertView;
        }

        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        TextView tvDesc = (TextView) view.findViewById(R.id.tvDesc);
        tvTitle.setText(feature.getTitle());
        tvDesc.setText(feature.getDesc());
        long uid = feature.getUid();
        if (uid == Feature.Menu.PROTECTION.ordinal()) {
            view.setBackgroundColor(Color.RED);
        } else if (uid == Feature.Menu.FINANCIAL_ACTIVITY.ordinal()) {
            view.setBackgroundColor(Color.GREEN);
        } else if (uid == Feature.Menu.IDENTITY_CARD.ordinal()) {
            view.setBackgroundColor(Color.YELLOW);
        } else if (uid == Feature.Menu.OTHER_CARD.ordinal()) {
            view.setBackgroundColor(Color.CYAN);
        } else if (uid == Feature.Menu.PAYMENT_CARD.ordinal()) {
            view.setBackgroundColor(Color.BLUE);
        }

        return view;
    }
}
