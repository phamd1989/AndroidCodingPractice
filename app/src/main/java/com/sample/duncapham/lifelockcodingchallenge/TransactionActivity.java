package com.sample.duncapham.lifelockcodingchallenge;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.sample.duncapham.lifelockcodingchallenge.adapters.TransactionListViewAdapter;
import com.sample.duncapham.lifelockcodingchallenge.models.Transaction;
import com.sample.duncapham.lifelockcodingchallenge.utils.GenerateData;

import java.util.ArrayList;
import java.util.List;


public class TransactionActivity extends ActionBarActivity {
    private ListView lvTransactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        lvTransactions = (ListView) findViewById(R.id.lvTransactions);
        setupData();
    }

    private void setupData() {
        final List<Transaction> arraysOfTransactions = new ArrayList<>();
        TransactionListViewAdapter adapter = new TransactionListViewAdapter(this, arraysOfTransactions);
        lvTransactions.setAdapter(adapter);
        GenerateData.generateAccountData();
        GenerateData.generateTransactionData();
        adapter.addAll(Transaction.getAllTransactions());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_transaction, menu);
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
