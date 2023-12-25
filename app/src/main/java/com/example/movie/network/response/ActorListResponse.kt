package com.example.movie.network.response

import com.example.movie.data.ActorVO
import com.google.gson.annotations.SerializedName

data class ActorListResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val result: List<ActorVO>
)