package com.sample.duncapham.lifelockcodingchallenge.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sample.duncapham.lifelockcodingchallenge.R;
import com.sample.duncapham.lifelockcodingchallenge.models.Transaction;

import java.util.List;

/**
 * Created by duncapham on 5/18/15.
 */
public class TransactionListViewAdapter extends ArrayAdapter<Transaction> {
    public TransactionListViewAdapter(Context context, List<Transaction> transactions) {
        super(context, 0, transactions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Transaction transaction = getItem(position);
        View view;
        if (convertView == null) {
            LayoutInflater inflator = LayoutInflater.from(getContext());
            view = inflator.inflate(R.layout.transaction_item, parent, false);
        } else {
            view = convertView;
        }

        TextView tvMerchant = (TextView) view.findViewById(R.id.tvMerchant);
        TextView tvAmount   = (TextView) view.findViewById(R.id.tvAmount);
        TextView tvDate = (TextView) view.findViewById(R.id.tvDate);
        TextView tvAccount = (TextView) view.findViewById(R.id.tvAccount);

        tvMerchant.setText(transaction.getMerchant());
        tvAmount.setText(transaction.getAmount());
        if (Double.parseDouble(transaction.getAmount()) > 0) {
            tvAmount.setTextColor(Color.parseColor("#00AD62"));
        } else {
            tvAmount.setTextColor(Color.parseColor("#0079FF"));
        }
        tvDate.setText(transaction.getDate());
        tvAccount.setText(transaction.getAccount().getName());
        return view;
    }
}
