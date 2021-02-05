package com.madhram.hramtsovtest.data.model

import com.google.gson.annotations.SerializedName

data class Results (

        @SerializedName("id")
        val id: Int,

        @SerializedName("name")
        val name: String,

        @SerializedName("image")
        val img: String,

)


