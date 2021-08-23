package com.sample.framework.mvvm.java.network.api;

import com.sample.framework.mvvm.java.network.model.User;

import java.util.List;

import io.reactivex.Single;

public interface APIs {

    Single<List<User>> getUsers();

}
