package com.madhram.hramtsovtest.data.model

import com.google.gson.annotations.SerializedName

data class CompanyResponse (

        @SerializedName("info")
        val info: Info,

        @SerializedName("results")
        val results: List<Results>,
)

