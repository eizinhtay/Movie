package com.example.movie.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie.data.MovieVO
import com.example.movie.delegate.BannerViewHolderDelegate
import com.example.movie.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.view_item_banner.view.ivBannerImage
import kotlinx.android.synthetic.main.view_item_banner.view.tvBannerMovieName

class BannerViewHolder(itemView: View, bannerDelegate: BannerViewHolderDelegate) : RecyclerView.ViewHolder(itemView) {
    private var mMovieVO: MovieVO? = null

    init {
        itemView.setOnClickListener {
            mMovieVO?.let { movieVO -> bannerDelegate.onItemClick(movieVO.id!!) }
        }
    }


    fun bindData(movieVO: MovieVO) {
        mMovieVO = movieVO

        itemView.tvBannerMovieName.text = movieVO.title
//        tvMovieRating.text = movieVO.voteAverage.toString()
//        //rbMovieRating.rating = movieVO.setRatingBaseOnFiveStar()
        Glide.with(itemView.context).load("$IMAGE_BASE_URL${movieVO.posterPath}")
            .into(itemView.ivBannerImage)

    }
}