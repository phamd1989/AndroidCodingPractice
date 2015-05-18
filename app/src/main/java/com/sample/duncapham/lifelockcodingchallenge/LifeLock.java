package com.sample.duncapham.lifelockcodingchallenge;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.activeandroid.ActiveAndroid;
import com.sample.duncapham.lifelockcodingchallenge.adapters.LifeLockFeatureAdapter;
import com.sample.duncapham.lifelockcodingchallenge.models.Feature;
import com.sample.duncapham.lifelockcodingchallenge.utils.GenerateData;

import java.util.ArrayList;


public class LifeLock extends ActionBarActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActiveAndroid.initialize(this);
        setContentView(R.layout.activity_lifelock);
        listView = (ListView) findViewById(R.id.lvFeatures);
        setupData();
    }

    private void setupData() {
        // Construct the data source
        final ArrayList<Feature> arrayOfFeatures = new ArrayList<Feature>();
        // Create the adapter to convert the array to views
        LifeLockFeatureAdapter adapter = new LifeLockFeatureAdapter(this, arrayOfFeatures);
        // Attach the adapter to a ListView
        listView.setAdapter(adapter);
        // load test data and save to database
        GenerateData.generateFeatureData();
        // query database
        adapter.addAll(Feature.getAllFeatures());

        // setup listener for Financial Activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Feature item = arrayOfFeatures.get(position);
                if (item.getUid() == Feature.Menu.FINANCIAL_ACTIVITY.ordinal()) {
                    Intent intent = new Intent(LifeLock.this, TransactionActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_life_lock, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
