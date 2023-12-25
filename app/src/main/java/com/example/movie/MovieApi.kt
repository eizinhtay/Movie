package com.example.movie

import android.database.Observable
import com.example.movie.data.MovieVO
import com.example.movie.network.response.CreditResponse
import com.example.movie.network.response.GenreResponse
import com.example.movie.network.response.MovieListResponse
import com.example.movie.utils.API_KEY
import com.example.movie.utils.GET_GENRE
import com.example.movie.utils.GET_MOVIE_BY_GENRE
import com.example.movie.utils.GET_MOVIE_CREDIT
import com.example.movie.utils.GET_MOVIE_DETAIL
import com.example.movie.utils.GET_NOW_PLAYING
import com.example.movie.utils.GET_POPULAR
import com.example.movie.utils.GET_TOP_RATED
import com.example.movie.utils.PARAM_API_KEY
import com.example.movie.utils.PARAM_PAGE
import com.example.movie.utils.PARAM_QUERY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET(GET_NOW_PLAYING)
    fun getNowPlayingMovies(
        @Query(PARAM_API_KEY) apiKey: String = API_KEY,
        @Query(PARAM_PAGE) page: Int = 1,
    ): Call<MovieListResponse>

    @GET(GET_POPULAR)
    fun getPopularMovies(
        @Query(PARAM_API_KEY) apiKey: String = API_KEY,
        @Query(PARAM_PAGE) page: Int = 1,
    ): Call<MovieListResponse>

    @GET(GET_TOP_RATED)
    fun getTopRatedMovies(
        @Query(PARAM_API_KEY) apiKey: String = API_KEY,
        @Query(PARAM_PAGE) page: Int = 1,
    ): Call<MovieListResponse>

    @GET(GET_GENRE)
    fun getGenre(
        @Query(PARAM_API_KEY) apiKey: String = API_KEY,
    ): Call<GenreResponse>

    @GET(GET_MOVIE_BY_GENRE)
    fun getMovieByGenre(
        @Query(PARAM_API_KEY) apiKey: String = API_KEY,
        @Query(PARAM_QUERY) genreId: Int,

        ): Call<MovieListResponse>

    @GET(GET_MOVIE_DETAIL)
    fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query(PARAM_API_KEY) apiKey: String = API_KEY
    ): Call<MovieVO>

    @GET(GET_MOVIE_CREDIT)
    fun getMovieCredit(
        @Path("movie_id") movieId: Int,
        @Query(PARAM_API_KEY) apiKey: String = API_KEY
    ): Call<CreditResponse>


}