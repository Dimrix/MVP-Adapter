package com.tsurkis.genericspresentationexperiments.screens.userdisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tsurkis.genericspresentationexperiments.R;

/**
 * Created by T.Surkis on 10-Jun-17.
 */
public class ActivityUserDisplay extends AppCompatActivity implements ViewContract.IUserDisplayView {
    private ViewContract.IUserDisplayPresenter presenter;
    private RecyclerView recyclerViewMVP, recyclerViewData;
    private AdapterUserDisplayMVP adapterUserDisplayMVP;
    private AdapterUserDisplayData adapterUserDisplayData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_display);

        recyclerViewData = (RecyclerView) findViewById(R.id.dataRecyclerView);
        recyclerViewData.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewMVP = (RecyclerView) findViewById(R.id.mvpRecyclerView);
        recyclerViewMVP.setLayoutManager(new LinearLayoutManager(this));

        presenter = new PresenterUserDisplay();
        presenter.loadView(this);
    }

    @Override
    public void displayAdapter() {
        startDataAdapter();
        startMVPAdapter();
    }

    private void startMVPAdapter() {
        adapterUserDisplayMVP = new AdapterUserDisplayMVP(presenter);
        recyclerViewMVP.setAdapter(adapterUserDisplayMVP);
    }

    private void startDataAdapter() {
        adapterUserDisplayData = new AdapterUserDisplayData(presenter);
        recyclerViewData.setAdapter(adapterUserDisplayData);
    }
}
