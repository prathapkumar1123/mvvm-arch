package com.sample.framework.mvvm.kotlin.data.repository

import com.sample.framework.mvvm.kotlin.data.api.ApiHelper
import com.sample.framework.mvvm.kotlin.data.model.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getUsers(): Single<List<User>> {
        return apiHelper.getUsers()
    }

}