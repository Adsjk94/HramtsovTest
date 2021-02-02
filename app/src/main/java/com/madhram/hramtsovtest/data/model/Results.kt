package com.madhram.hramtsovtest.data.model

import com.google.gson.annotations.SerializedName

data class Results (

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("img")
    val img: String,
)


