package com.sample.duncapham.lifelockcodingchallenge;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.sample.duncapham.lifelockcodingchallenge.models.Transaction;


public class TransactionDetailsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_details);

        Transaction transaction = (Transaction) getIntent().getSerializableExtra("data");
        setupData(transaction);
    }

    private void setupData(Transaction transaction) {
        TextView tvAmountValue   = (TextView) findViewById(R.id.tvAmountValue);
        TextView tvDateValue     = (TextView) findViewById(R.id.tvDateValue);
        TextView tvAccountValue  = (TextView) findViewById(R.id.tvAccountValue);
        TextView tvMerchantValue = (TextView) findViewById(R.id.tvMerchantValue);
        TextView tvCategoryValue = (TextView) findViewById(R.id.tvCategoryValue);

        tvAmountValue.setText(transaction.getAmount());
        tvDateValue.setText(transaction.getDate());
        tvAccountValue.setText(transaction.getAccount().getName());
        tvMerchantValue.setText(transaction.getMerchant());
        tvMerchantValue.setText(transaction.getCategory());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_transaction_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
