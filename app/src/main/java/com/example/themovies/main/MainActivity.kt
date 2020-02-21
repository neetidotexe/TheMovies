package com.example.themovies.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themovies.R
import com.example.themovies.model.Movies
import com.example.themovies.network.TMDBApiRepository


class MainActivity : AppCompatActivity(), MoviesView {

    private lateinit var recyclerView:RecyclerView
    private lateinit var presenter: MoviesPresenter
    private lateinit var adapter: MoviesAdapter
    private var movies:MutableList<Movies> = mutableListOf()

    override fun showMovieList(movieData: List<Movies>) {
        movies.clear()
        movies.addAll(movieData)
        adapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter= MoviesPresenter(this, TMDBApiRepository())
        presenter.getMovieList()

        recyclerView=findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager=GridLayoutManager(this,3)

        adapter=MoviesAdapter(movies,this)
        recyclerView.adapter=adapter




    }

}
