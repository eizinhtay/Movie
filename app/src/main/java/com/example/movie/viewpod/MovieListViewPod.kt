package com.example.movie.viewpod

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.example.movie.adapters.MovieAdapter
import com.example.movie.data.MovieVO
import com.example.movie.delegate.MovieListViewHolderDelegate
import kotlinx.android.synthetic.main.view_pod_movie_list.view.*


class MovieListViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null

) : RelativeLayout(context, attrs) {

    lateinit var mMovieAdapter : MovieAdapter


    override fun onFinishInflate() {
        setMovieRecyclerView()
        super.onFinishInflate()
    }

    fun setUpMovieListViewPod(delegate: MovieListViewHolderDelegate){
        setDelegate(delegate)
        setMovieRecyclerView()
    }

    fun setDelegate(delegate: MovieListViewHolderDelegate){
    }

    private fun setMovieRecyclerView() {
        mMovieAdapter = MovieAdapter()
        rvMovieList.adapter = mMovieAdapter
    }

    fun setNewData(items: List<MovieVO>){
        mMovieAdapter.setNewData(items)

    }
}