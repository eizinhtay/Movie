package com.example.movie.data

import com.google.gson.annotations.SerializedName

class ProductionCountriesVO(
    @SerializedName("iso_3166_1")
    val iso: String,
    @SerializedName("name")
    val name: String
)
