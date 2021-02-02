package com.madhram.hramtsovtest.data.api

class ApiHelper (private val apiService: ApiService) {
    fun getCompanies() = apiService.getCompanies()
}