package com.madhram.hramtsovtest.data.repositore

import com.madhram.hramtsovtest.data.api.ApiHelper
import com.madhram.hramtsovtest.data.model.CompanyResponse
import io.reactivex.Single

class MainRepositore (private val apiHelper: ApiHelper) {

    fun getCompanies(): Single<List<CompanyResponse>> {
        val response = apiHelper.getCompanies()
        return response.map {
            it.results
        }
    }
}
