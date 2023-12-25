package com.example.movie.network

import com.example.movie.data.DateVO
import com.example.movie.data.MovieVO
import com.google.gson.annotations.SerializedName

data class MovieResponse(

	@field:SerializedName("dates")
	val dates: DateVO? = null,

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("results")
	val results: List<MovieVO?>? = null,

	@field:SerializedName("total_results")
	val totalResults: Int? = null
)


