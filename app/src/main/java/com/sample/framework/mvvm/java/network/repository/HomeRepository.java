package com.sample.framework.mvvm.java.network.repository;

import android.content.Context;

import com.sample.framework.mvvm.java.network.api.ApiClient;
import com.sample.framework.mvvm.java.network.model.User;
import com.sample.framework.mvvm.java.base.BaseRepository;

import java.util.List;

import io.reactivex.Single;

public class HomeRepository extends BaseRepository {

    public HomeRepository(Context context, ApiClient apiClient) {
        super(context, apiClient);
    }

    public Single<List<User>> getUsers() {
        return apiClient.getAPI().getUsers();
    }

}
