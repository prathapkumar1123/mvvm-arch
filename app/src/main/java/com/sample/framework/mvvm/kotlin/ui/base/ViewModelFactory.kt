package com.sample.framework.mvvm.kotlin.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.framework.mvvm.kotlin.data.api.ApiHelper
import com.sample.framework.mvvm.kotlin.data.repository.MainRepository
import com.sample.framework.mvvm.kotlin.ui.main.viewmodel.MainViewModel

open class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}