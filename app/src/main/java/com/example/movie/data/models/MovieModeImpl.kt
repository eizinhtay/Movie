package com.example.movie.data.models

import com.example.movie.data.GenreVO
import com.example.movie.data.MovieVO
import com.example.movie.network.dataAgent.MovieDataAgent
import com.example.movie.network.dataAgent.RetrofitMovieDataAgentImpl

object MovieModeImpl : MovieModel {
    private val movieDataAgent: MovieDataAgent = RetrofitMovieDataAgentImpl



    override fun getNowPlayingMovies(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        movieDataAgent.getNowPlayMovies(onSuccess = onSuccess, onFailure = onFailure)

    }

    override fun getPopularMovies(onSuccess: (List<MovieVO>) -> Unit, onFailure: (String) -> Unit) {
        movieDataAgent.getPopularMovies(onSuccess = onSuccess, onFailure = onFailure)
    }

    override fun getTopRatedMovies(onSuccess: (List<MovieVO>) -> Unit, onFailure: (String) -> Unit) {
        movieDataAgent.getTopRatedMovies(onSuccess = onSuccess, onFailure = onFailure)
    }

    override fun getGenres(onSuccess: (List<GenreVO>) -> Unit, onFailure: (String) -> Unit) {
        movieDataAgent.getGenres(onSuccess = onSuccess, onFailure = onFailure)
    }

    override fun getMoviesByGenre(
        genreId: Int,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        movieDataAgent.getMoviesByGenre(genreId = genreId, onSuccess = onSuccess, onFailure = onFailure)
    }
    override fun getMovieDetailById(
        movieId: Int,
        onSuccess: (MovieVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        movieDataAgent.getMovieDetailId(movieId = movieId, onSuccess = onSuccess, onFailure = onFailure)
    }
}