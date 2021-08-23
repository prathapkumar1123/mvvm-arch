package com.sample.framework.mvvm.java.base;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel {

    public final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public BaseViewModel() {}

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }

}
