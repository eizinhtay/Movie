package com.example.movie.network.dataAgent

import com.example.movie.data.GenreVO
import com.example.movie.data.MovieVO

interface MovieDataAgent {
    //toSendHowDataType
    fun getNowPlayMovies(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getPopularMovies(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getTopRatedMovies(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )


    fun getGenres(
        onSuccess: (List<GenreVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getMoviesByGenre(
        genreId:Int,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getMovieDetailId(
        movieId:Int,
        onSuccess: (MovieVO) -> Unit,
        onFailure: (String) -> Unit
    )
}