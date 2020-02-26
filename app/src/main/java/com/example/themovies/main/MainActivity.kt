package com.example.themovies.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //by default, show top rated movies
        showTopRatedMovie()

    }

    private fun showTopRatedMovie(){
        presenter= MoviesPresenter(this, TMDBApiRepository())
        presenter.getTopRatedMovieList()

        recyclerView=findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager=GridLayoutManager(this,3)

        adapter=MoviesAdapter(movies,this)
        recyclerView.adapter=adapter
    }

    private fun showPopularMovie(){
        presenter= MoviesPresenter(this, TMDBApiRepository())
        presenter.getPopularMovieList()

        recyclerView=findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager=GridLayoutManager(this,3)

        adapter=MoviesAdapter(movies,this)
        recyclerView.adapter=adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuitem_PopularMovie -> {
                showPopularMovie()
                true
            }
            R.id.menuitem_TopRatedmovies -> {
                showTopRatedMovie()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
