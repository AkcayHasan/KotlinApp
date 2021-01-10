package com.hasanakcay.kotlinapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.hasanakcay.kotlinapp.R
import com.hasanakcay.kotlinapp.adapter.AlbumsAdapter
import com.hasanakcay.kotlinapp.viewmodel.AlbumsPageViewModel
import kotlinx.android.synthetic.main.fragment_albums_page.*

class AlbumsPage : Fragment(R.layout.fragment_albums_page) {

    private lateinit var viewModel : AlbumsPageViewModel
    private val albumsAdapter = AlbumsAdapter(arrayListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AlbumsPageViewModel::class.java)
        viewModel.dataFromJson()

        recycView.layoutManager = LinearLayoutManager(context)
        recycView.adapter = albumsAdapter

        observeLiveData()
    }
    fun observeLiveData(){
        viewModel.albums.observe(viewLifecycleOwner, Observer { albums ->
            albums?.let {
                albumsAdapter.newAlbumList(albums)
            }
        })
    }

}