package com.madhram.hramtsovtest.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.madhram.hramtsovtest.data.api.ApiHelper
import com.madhram.hramtsovtest.data.repositore.MainRepositore
import com.madhram.hramtsovtest.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepositore(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}