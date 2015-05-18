package com.sample.duncapham.lifelockcodingchallenge;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sample.duncapham.lifelockcodingchallenge.adapters.TransactionListViewAdapter;
import com.sample.duncapham.lifelockcodingchallenge.listeners.EndlessScrollListener;
import com.sample.duncapham.lifelockcodingchallenge.models.Transaction;
import com.sample.duncapham.lifelockcodingchallenge.utils.GenerateData;

import java.util.ArrayList;
import java.util.List;


public class TransactionActivity extends ActionBarActivity {
    private ListView lvTransactions;
    private TransactionListViewAdapter adapter;
    List<Transaction> transactions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        lvTransactions = (ListView) findViewById(R.id.lvTransactions);
        setupData();

        // infinite scrolling
        lvTransactions.setOnScrollListener(new EndlessScrollListener() {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                customLoadMoreData(page);
            }
        });

        // detail view
        lvTransactions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Transaction transaction = adapter.getItem(position);
                Intent intent = new Intent(TransactionActivity.this, TransactionDetailsActivity.class);
                intent.putExtra("data", transaction);
                startActivity(intent);
            }
        });
    }

    private void customLoadMoreData(int page) {
        if (transactions.size() > 20 * (page-1)) {
            int limit;
            if (transactions.size() < 20*page) {
                limit = transactions.size();
            } else {
                limit = 20 * page;
            }
            adapter.addAll(transactions.subList(20*(page-1), limit));
        }
    }

    private void setupData() {
        final List<Transaction> arraysOfTransactions = new ArrayList<>();
        adapter = new TransactionListViewAdapter(this, arraysOfTransactions);
        lvTransactions.setAdapter(adapter);
        GenerateData.generateAccountData();
        GenerateData.generateTransactionData();
        // only pick at most 20 items
        transactions = Transaction.getAllTransactions();
        if (transactions.size() > 20) {
            adapter.addAll(transactions.subList(0,20));
        } else {
            adapter.addAll(Transaction.getAllTransactions());
        }
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
