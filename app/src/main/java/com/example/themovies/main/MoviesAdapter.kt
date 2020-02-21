package com.example.themovies.main

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themovies.BuildConfig.URL_POSTER
import com.example.themovies.R
import com.example.themovies.model.Movies


class MoviesAdapter(private val result:List<Movies>, private val context: Context ) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.movies_list,parent,false)
        return MovieViewHolder(v)
    }

    override fun getItemCount(): Int {
        return result.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        Glide.with(context)
            .load(URL_POSTER + result[position].posterPath)
            .into(holder.movieImage)
    }

    class MovieViewHolder(viewHolder: View):RecyclerView.ViewHolder(viewHolder){
        val movieImage=viewHolder.findViewById<ImageView>(R.id.image_movieImage)
    }
}