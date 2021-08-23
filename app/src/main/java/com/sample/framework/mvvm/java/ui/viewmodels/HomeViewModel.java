package com.sample.framework.mvvm.java.ui.viewmodels;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.sample.framework.mvvm.java.network.api.ApiClient;
import com.sample.framework.mvvm.java.network.model.User;
import com.sample.framework.mvvm.java.network.repository.HomeRepository;
import com.sample.framework.mvvm.java.base.BaseViewModel;
import com.sample.framework.mvvm.java.network.responsemodels.BaseResponse;
import com.sample.framework.mvvm.java.network.model.Status;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends BaseViewModel {

    private final HomeRepository homeRepository;
    public final MutableLiveData<BaseResponse<List<User>>> users;

    public HomeViewModel(Context context) {
        homeRepository = new HomeRepository(context, new ApiClient(context));
        users = new MutableLiveData<>();
    }

    public void fetchUsers() {
        users.postValue(new BaseResponse<>(Status.LOADING));

        Disposable d = homeRepository.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((userList, exception) -> {
                    if (exception != null) {
                        users.postValue(new BaseResponse<>(Status.ERROR));
                    } else {
                        users.postValue(new BaseResponse<>(userList));
                    }
                });


        compositeDisposable.add(d);
    }

}
