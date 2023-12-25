package com.example.movie.data

import com.google.gson.annotations.SerializedName


data class DateVO(

    @field:SerializedName("maximum")
    val maximum: String? = null,

    @field:SerializedName("minimum")
    val minimum: String? = null
)