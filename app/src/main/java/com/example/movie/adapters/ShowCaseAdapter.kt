package com.example.movie.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.movie.R
import com.example.movie.data.MovieVO
import com.example.movie.viewholder.ShowCaseViewHolder

class ShowCaseAdapter : Adapter<ShowCaseViewHolder>() {
    private var mMovieList: List<MovieVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowCaseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_showcases, parent, false)
        return ShowCaseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mMovieList.count()
    }

    override fun onBindViewHolder(holder: ShowCaseViewHolder, position: Int) {
        if (mMovieList.isNotEmpty()){
            holder.bind(mMovieList[position])

        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(items: List<MovieVO>) {
        mMovieList = items
        notifyDataSetChanged()
    }
}