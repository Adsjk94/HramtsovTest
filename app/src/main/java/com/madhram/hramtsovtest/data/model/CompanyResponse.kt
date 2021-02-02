package com.madhram.hramtsovtest.data.model

import com.google.gson.annotations.SerializedName


data class CompanyResponse (

    @SerializedName("results")
    val results: List<CompanyResponse>,
)

