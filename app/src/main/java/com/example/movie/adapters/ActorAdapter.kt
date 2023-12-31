package com.example.movie.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.data.ActorVO
import com.example.movie.viewholder.ActorViewHolder


class ActorAdapter : RecyclerView.Adapter<ActorViewHolder>() {

    private var list: List<ActorVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_actor, parent, false)
        return ActorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        if (list.isNotEmpty()){
            holder.bindData(list[position])
        }
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(actors: List<ActorVO>) {
        list = actors
        notifyDataSetChanged()
    }
}