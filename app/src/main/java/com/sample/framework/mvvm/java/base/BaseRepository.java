package com.sample.framework.mvvm.java.base;

import android.content.Context;

import com.sample.framework.mvvm.java.network.api.ApiClient;

public abstract class BaseRepository {

    public final Context context;
    public final ApiClient apiClient;

    public BaseRepository(Context context, ApiClient apiClient) {
        this.context = context;
        this.apiClient = apiClient;
    }

}
