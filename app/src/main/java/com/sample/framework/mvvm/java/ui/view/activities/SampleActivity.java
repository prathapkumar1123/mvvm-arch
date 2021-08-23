package com.sample.framework.mvvm.java.ui.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sample.framework.mvvm.R;
import com.sample.framework.mvvm.java.ui.adapters.MainAdapter;

public class SampleActivity extends AppCompatActivity implements MainAdapter.MainAdapterListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

    }

    @Override
    public void onItemClicked() {

    }

    @Override
    public void onSuccessClicked() {
        onBackPressed();
    }

}