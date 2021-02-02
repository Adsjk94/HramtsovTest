package com.madhram.hramtsovtest.data.api

import com.madhram.hramtsovtest.data.model.CompanyResponse
import io.reactivex.Single

interface ApiService {
    fun getCompanies(): Single<CompanyResponse>
}