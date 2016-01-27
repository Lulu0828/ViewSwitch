package com.lulu.viewswitch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static boolean isGridView = true;

    private GridView mGridView;
    private ListView mListView;

    private List<ServiceBean> mService = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mGridView = (GridView) findViewById(R.id.app_grid);
        mListView = (ListView) findViewById(R.id.app_list);

        setData();

        updateLayout();

    }

    private void setData() {
        for (int i = 0; i < 16; i ++) {
            ServiceBean serviceBean = new ServiceBean();
            serviceBean.setIconId(R.drawable.icon);
            serviceBean.setName("喵星人");
            mService.add(serviceBean);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_change) {
            isGridView = !isGridView;
            updateLayout();

        }
        return super.onOptionsItemSelected(item);
    }

    private void updateLayout() {
        if (isGridView) {
            if (mGridView == null) {
                mGridView = (GridView) findViewById(R.id.app_grid);
            }
            mGridView.setVisibility(View.VISIBLE);
            mGridView.setAdapter(new ServiceZoneAdapter(this, mService));
            mListView.setVisibility(View.GONE);
        } else {
            if (mListView == null) {
                mListView = (ListView) findViewById(R.id.app_list);
            }
            mListView.setVisibility(View.VISIBLE);
            mListView.setAdapter(new ServiceZoneAdapter(this, mService));
            mGridView.setVisibility(View.GONE);
        }
    }
}
