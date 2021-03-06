package com.madhram.hramtsovtest.data.api

import com.madhram.hramtsovtest.data.model.CompanyResponse
import io.reactivex.Single
import com.rx2androidnetworking.Rx2AndroidNetworking

class ApiServiceImp : ApiService {

    override fun getCompanies(): Single<CompanyResponse> =
        Rx2AndroidNetworking.get("https://rickandmortyapi.com/api/character")
            .build()
            .getObjectSingle(CompanyResponse::class.java)

}