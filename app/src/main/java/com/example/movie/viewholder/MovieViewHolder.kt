package com.example.movie.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.movie.data.MovieVO
import com.example.movie.delegate.MovieListViewHolderDelegate
import com.example.movie.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.view_holder_movie.view.ivMovieImage
import kotlinx.android.synthetic.main.view_holder_movie.view.rbMovieRating
import kotlinx.android.synthetic.main.view_holder_movie.view.tvMovieName
import kotlinx.android.synthetic.main.view_holder_movie.view.tvMovieRating

class MovieViewHolder(itemView: View,) : ViewHolder(itemView) {
    private var mMovieVO: MovieVO? = null


    init {
        itemView.setOnClickListener {
        }
    }


    fun bind(movieVO: MovieVO) {
        mMovieVO = movieVO
        itemView.apply {
            Glide.with(itemView.context).load("$IMAGE_BASE_URL${mMovieVO!!.posterPath}")
                .into(itemView.ivMovieImage)
            tvMovieName.text = movieVO.title
            tvMovieRating.text = movieVO.voteAverage?.toString()
            rbMovieRating.rating = movieVO.setRatingBaseOnFiveStar()
        }
    }
}