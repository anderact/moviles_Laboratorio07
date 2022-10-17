package com.chacon.axel.tecsupfy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chacon.axel.tecsupfy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var trackListRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        trackListRecyclerView = binding.tracksList
        trackListRecyclerView.layoutManager = LinearLayoutManager(this)
        val songs = SongRepository()
        val tracksAdapter = TracksAdapter(songs.songs)
        trackListRecyclerView.adapter = tracksAdapter
    }
}