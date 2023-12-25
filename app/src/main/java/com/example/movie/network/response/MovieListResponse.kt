package com.example.movie.network.response

import com.example.movie.data.DateVO
import com.example.movie.data.MovieVO
import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("dates")
    val dates: DateVO?,
    @SerializedName("results")
    val results: List<MovieVO>?
)
