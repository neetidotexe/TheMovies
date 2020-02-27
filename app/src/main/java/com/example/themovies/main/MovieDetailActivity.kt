package com.example.themovies.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.themovies.BuildConfig
import com.example.themovies.R

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        try {

            val image_movieImage:ImageView=findViewById(R.id.image_backdropMovieImage)
            Glide.with(this)
                .load(intent.getStringExtra("BackdropPath"))
                .into(image_movieImage)


            val text_movieName: TextView = findViewById(R.id.text_movieName)
            text_movieName.setText(intent.getStringExtra("Title")).toString()

            val text_movieOverview:TextView=findViewById(R.id.text_movieOverview)
            text_movieOverview.setText(intent.getStringExtra("Overview")).toString()
        }
        catch (ex:Exception){
            val toast= Toast.makeText(this,ex.message,Toast.LENGTH_LONG)
            toast.show()
        }
    }
}
