package com.sample.framework.mvvm.java.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity<T extends ViewDataBinding, B extends BaseViewModel>
        extends AppCompatActivity {

    protected T dataBinding;
    protected B viewModel;

    protected BaseViewModel baseViewModel;
    protected ViewModelProviderFactory viewModelProviderFactory;

    protected void bindView(int layoutId) {
        dataBinding = DataBindingUtil.setContentView(this, layoutId);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModelProviderFactory = new ViewModelProviderFactory(this);
        setupViewModel();

        configureViews();
        configureListeners();
        configureObservers();
    }

    protected abstract void setupViewModel();

    protected abstract void configureViews();

    protected abstract void configureListeners();

    protected abstract void configureObservers();

    public T getViewDataBinding() {
        return dataBinding;
    }

    public B getViewModel() {
        return viewModel;
    }

    @Override
    protected void onDestroy() {
        viewModel.compositeDisposable.dispose();
        super.onDestroy();
    }



}
