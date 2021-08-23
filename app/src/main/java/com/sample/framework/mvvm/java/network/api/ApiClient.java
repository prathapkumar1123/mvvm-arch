package com.sample.framework.mvvm.java.network.api;

import android.content.Context;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://14.99.204.141/dayamed-dev/api/";
    private static final String BASE_URL_REST = "https://14.99.204.141/dayamed-dev/api/rest/";

    private final Context context;
    private Retrofit retrofit = null;

    public ApiClient(Context context) {
        this.context = context;
    }

    private Retrofit getRetrofit(String url) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit == null || !retrofit.baseUrl().toString().matches(url)) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(getClient())
                    .build();
        }

        return retrofit;
    }

    private OkHttpClient getClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(logging);
        httpClient.addNetworkInterceptor(new StethoInterceptor());

        return httpClient.build();
    }

    /**
     * This method creates a new instance of the API interface.
     * @return The API interface
     */
    private APIs getAPI(Context context, String url) {
        return getRetrofit(url).create(APIs.class);
    }

    public APIs getAPI() {
        return getAPI(context, BASE_URL);
    }

    public APIs getAPIRest() {
        return getAPI(context, BASE_URL_REST);
    }

}
