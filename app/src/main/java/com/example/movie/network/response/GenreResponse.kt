package com.example.movie.network.response

import com.example.movie.data.GenreVO
import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("genres")
    val genres: List<GenreVO>
)
