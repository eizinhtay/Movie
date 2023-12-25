package com.example.movie.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.movie.data.MovieVO
import com.example.movie.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.view_holder_showcases.view.ivShowCase
import kotlinx.android.synthetic.main.view_holder_showcases.view.tvMovieShowCaseDate
import kotlinx.android.synthetic.main.view_holder_showcases.view.tvMovieShowCaseName

class ShowCaseViewHolder(itemView: View) : ViewHolder(itemView) {
    private var mMovieVO: MovieVO? = null

    fun  bind(movieVO: MovieVO){
        itemView.apply {
            Glide.with(context).load("$IMAGE_BASE_URL${movieVO.posterPath}").into(ivShowCase)
            tvMovieShowCaseName.text = movieVO.title
            tvMovieShowCaseDate.text = movieVO.releaseDate
        }
    }
}