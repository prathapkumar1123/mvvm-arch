package com.sample.framework.mvvm.java.ui.view.activities;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sample.framework.mvvm.R;
import com.sample.framework.mvvm.databinding.ActivityHomeBinding;
import com.sample.framework.mvvm.java.base.BaseActivity;
import com.sample.framework.mvvm.java.network.model.User;
import com.sample.framework.mvvm.java.ui.adapters.MainAdapter;
import com.sample.framework.mvvm.java.ui.viewmodels.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeViewModel> {

    MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView(R.layout.activity_home);

        viewModel.fetchUsers();
    }

    @Override
    protected void configureViews() {
        mMainAdapter = new MainAdapter(new ArrayList<>());
        dataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataBinding.recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));
        dataBinding.recyclerView.setAdapter(mMainAdapter);
    }

    @Override
    protected void configureListeners() {
        // No listeners yet.
    }

    @Override
    protected void configureObservers() {
        viewModel.users.observe(this, listBaseResponse -> {
            switch (listBaseResponse.getStatus()) {
                case LOADING:
                    showLoader();
                    break;
                case SUCCESS:
                    dataBinding.progressBar.setVisibility(View.GONE);
                    renderList(listBaseResponse.responseData);
                    dataBinding.recyclerView.setVisibility(View.VISIBLE);
                    break;
                case ERROR:
                    dataBinding.recyclerView.setVisibility(View.GONE);
                    dataBinding.progressBar.setVisibility(View.GONE);
                    break;
            }
        });
    }

    private void showLoader() {
        dataBinding.recyclerView.setVisibility(View.GONE);
        dataBinding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void setupViewModel() {
        viewModel = viewModelProviderFactory.getHomeViewModel();
    }

    private void renderList(List<User> users) {
        mMainAdapter.addData(users);
        mMainAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.compositeDisposable.dispose();
    }

}