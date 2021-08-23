package com.sample.framework.mvvm.kotlin.data.api

import com.sample.framework.mvvm.kotlin.data.model.User
import io.reactivex.Single

interface ApiService {

    fun getUsers(): Single<List<User>>

}