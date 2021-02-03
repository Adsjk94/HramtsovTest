package com.madhram.hramtsovtest.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.madhram.hramtsovtest.data.model.CompanyResponse
import com.madhram.hramtsovtest.data.repositore.MainRepositore
import com.madhram.hramtsovtest.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepositore: MainRepositore) : ViewModel() {

    private val companies = MutableLiveData<Resource<List<CompanyResponse>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        FetchCompanies()
    }

    private fun FetchCompanies() {
        companies.postValue(Resource.loading(null))
        compositeDisposable.add(
                mainRepositore.getCompanies()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({companiesList ->
                            companies.postValue(Resource.success(companiesList))
                        },{
                            companies.postValue(Resource.error( null))
                        })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getCompanies(): LiveData<Resource<List<CompanyResponse>>> = companies

}